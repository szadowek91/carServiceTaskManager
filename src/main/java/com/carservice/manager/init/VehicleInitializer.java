package com.carservice.manager.init;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class VehicleInitializer {


    private final VehicleRepository vehicleRepository;

    public VehicleInitializer(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

//    @EventListener
//    public void appReady(ApplicationReadyEvent event){
//        vehicleRepository.addVehicle(new VehicleModel("ZK9090","Audi","A4","Blue",1999, new Date()));
//    }



}
