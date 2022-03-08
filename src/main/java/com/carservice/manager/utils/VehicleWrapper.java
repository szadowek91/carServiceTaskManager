package com.carservice.manager.utils;

import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;

public class VehicleWrapper {


    public static VehicleEntity parse(VehicleModel vehicleModel) {

        return new VehicleEntity(
                vehicleModel.getRegistrationNumber(),
                vehicleModel.getMark(),
                vehicleModel.getModel(),
                vehicleModel.getColor(),
                vehicleModel.getProductionYear()
        );
    }
}
