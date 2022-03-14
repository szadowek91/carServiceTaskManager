package com.carservice.manager.service;

import com.carservice.manager.config.Log4J2YamlConfig;
import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleDbRepository;
import com.carservice.manager.utils.VehicleWrapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Validated
@Service
public class VehicleDbService {

    private final VehicleDbRepository vehicleDbRepository;

    public VehicleDbService(VehicleDbRepository vehicleDbRepository) {
        this.vehicleDbRepository = vehicleDbRepository;
    }

    Log4J2YamlConfig logger = new Log4J2YamlConfig();


    public VehicleEntity addVehicle(VehicleModel vehicleModel) {
        logger.infoLogEnterIntoMethod("addVehicle/DbService");
        VehicleEntity vehicleEntity = VehicleWrapper.parse(vehicleModel);
        vehicleEntity.setId(Long.valueOf(UUID.randomUUID().hashCode()));
        vehicleEntity.setAdmissionDate(new Date());
        logger.infoLogSuccess();
        return vehicleDbRepository.save(vehicleEntity);
    }

    public List<VehicleEntity> getVehicleModels() {
        logger.infoLogEnterIntoMethod("getVehicleModels/DbService");
        logger.infoLogSuccess();
        return vehicleDbRepository.findAll();
    }

    public List<VehicleEntity> findAllByInput(String input) {
        logger.infoLogEnterIntoMethod("findAllByInput/DbService");
        logger.infoLogSuccess();
        return vehicleDbRepository.findAllByMarkContainingIgnoreCaseOrModelContainingIgnoreCaseOrRegistrationNumberContainingIgnoreCase(input, input, input);
    }

    public List<VehicleEntity> findCarsBeforeRepair() {
        logger.infoLogEnterIntoMethod("findCarsBeforeRepair/DbService");
        logger.infoLogSuccess();
        return vehicleDbRepository.findAllByStatusEquals(false);
    }

    public List<VehicleEntity> findCarsAfterRepair() {
        logger.infoLogEnterIntoMethod("findCarsAfterRepair/DbService");
        logger.infoLogSuccess();
        return vehicleDbRepository.findAllByStatusEquals(true);
    }

    @Transactional
    public void repair(Long id) {
        logger.infoLogEnterIntoMethod("repair/DbService");
        VehicleEntity vehicle = vehicleDbRepository.findById(id).get();
        vehicle.setStatus(true);
        vehicle.setRepairDate(new Date());
        logger.infoLogSuccess();
    }
}
