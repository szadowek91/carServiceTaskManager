package com.carservice.manager.service;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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


    public List<VehicleModel> getVehicleModels(){
        return vehicleRepository.getVehicleModels();
    }


}
