package com.carservice.manager.controller;

import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleDbRepository;
import com.carservice.manager.service.VehicleDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping ("/api/vehicle")
@RequiredArgsConstructor
public class VehicleRestController {

    private final VehicleDbService vehicleDbService;

    @GetMapping("/search")
    public List<VehicleEntity> searchForVehicle(@PathParam("input") String input){
        return vehicleDbService.findAllByInput(input);
    }

    @PostMapping()
    public VehicleEntity addVehicle(@RequestBody VehicleModel vehicleModel){
        return vehicleDbService.addVehicle(vehicleModel);
    }


    @GetMapping("/not-repaired")
    public List<VehicleEntity> searchForVehicleIsNotRepaired(){
        return vehicleDbService.findCarsBeforeRepair();
    }


    @GetMapping("/repaired")
    public List<VehicleEntity> searchForVehicleIsRepaired(){
        return vehicleDbService.findCarsAfterRepair();
    }

    @PostMapping("/fix")
    public void fixVehicle (@PathParam("id") Long id){
        vehicleDbService.repair(id);
    }
}
