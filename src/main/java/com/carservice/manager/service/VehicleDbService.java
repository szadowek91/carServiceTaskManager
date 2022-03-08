package com.carservice.manager.service;

import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleDbRepository;
import com.carservice.manager.utils.DateUtils;
import com.carservice.manager.utils.VehicleWrapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Validated
@Service
public class VehicleDbService {
    
    private final VehicleDbRepository vehicleDbRepository;

    public VehicleDbService(VehicleDbRepository vehicleDbRepository) {
        this.vehicleDbRepository = vehicleDbRepository;
    }

    public VehicleEntity addVehicle(VehicleModel vehicleModel) {
        VehicleEntity vehicleEntity = VehicleWrapper.parse(vehicleModel);
        vehicleEntity.setId(Long.valueOf(UUID.randomUUID().hashCode()));
        vehicleEntity.setAdmissionDate(new Date());
        return vehicleDbRepository.save(vehicleEntity);
    }

    public List<VehicleEntity> getVehicleModels() {
        return vehicleDbRepository.findAll();
    }

    public List<VehicleEntity> findAllByInput(String input) {
        return vehicleDbRepository.findAllByMarkContainingIgnoreCaseOrModelContainingIgnoreCaseOrRegistrationNumberContainingIgnoreCase(input, input, input);
    }

    public List<VehicleEntity> findCarsBeforeRepair() {
        return vehicleDbRepository.findAllByStatusEquals(false);
    }

    public List<VehicleEntity> findCarsAfterRepair() {
        return vehicleDbRepository.findAllByStatusEquals(true);
    }

    @Transactional
    public void repair (Long id){
        VehicleEntity vehicle = vehicleDbRepository.findById(id).get();
        vehicle.setStatus(true);
        vehicle.setRepairDate(new Date());
//        vehicleDbRepository.save(vehicle);

    }

}
