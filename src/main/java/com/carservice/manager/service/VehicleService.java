package com.carservice.manager.service;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public void addVehicle(VehicleModel vehicleModel) {
        vehicleModel.setId(UUID.randomUUID().hashCode());
        vehicleRepository.addVehicle(vehicleModel);
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleRepository.getVehicleModels();
    }

    public void addAllVehicles(List<VehicleModel> listVM) {
        vehicleRepository.addAll(listVM);
    }

    public List<VehicleModel> findAllByInput(String input) {
        return vehicleRepository.findAll().stream()
                .filter
                        (i -> i.getMark().toUpperCase().contains(input.toUpperCase())
                                || i.getModel().toUpperCase().contains(input.toUpperCase())
                                || i.getRegistrationNumber().toUpperCase().contains(input.toUpperCase()))
                .collect(Collectors.toList());
    }
}
