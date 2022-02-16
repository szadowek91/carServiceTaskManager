package com.carservice.manager.repository;

import com.carservice.manager.model.VehicleModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {


    private List<VehicleModel> vehicleModels;


    public VehicleRepository() {
        vehicleModels = new ArrayList<>();
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }


    public void addVehicle(VehicleModel vehicleModel) {
        vehicleModels.add(vehicleModel);
    }

}
