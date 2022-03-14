package com.carservice.manager.controller;

import com.carservice.manager.config.Log4J2YamlConfig;
import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.service.VehicleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleRestController {

    private final VehicleDbService vehicleDbService;

    Log4J2YamlConfig logger = new Log4J2YamlConfig();

    @GetMapping("/search")
    public List<VehicleEntity> searchForVehicle(@PathParam("input") String input) {
        logger.infoLogEnterIntoMethod("searchForVehicle/VehicleRestCtrl");
        logger.infoLogSuccess();
        return vehicleDbService.findAllByInput(input);
    }

    @PostMapping()
    public VehicleEntity addVehicle(@RequestBody VehicleModel vehicleModel) {
        logger.infoLogEnterIntoMethod("addVehicle/VehicleRestCtrl");
        logger.infoLogSuccess();
        return vehicleDbService.addVehicle(vehicleModel);
    }


    @GetMapping("/not-repaired")
    public List<VehicleEntity> searchForVehicleIsNotRepaired() {
        logger.infoLogEnterIntoMethod("searchForVehicleIsNotRepaired/VehicleRestCtrl");
        logger.infoLogSuccess();
        return vehicleDbService.findCarsBeforeRepair();
    }


    @GetMapping("/repaired")
    public List<VehicleEntity> searchForVehicleIsRepaired() {
        logger.infoLogEnterIntoMethod("searchForVehicleIsRepaired/VehicleRestCtrl");
        logger.infoLogSuccess();
        return vehicleDbService.findCarsAfterRepair();
    }

    @PostMapping("/fix")
    public void fixVehicle(@PathParam("id") Long id) {
        logger.infoLogEnterIntoMethod("fixVehicle/VehicleRestCtrl");
        logger.infoLogSuccess();
        vehicleDbService.repair(id);
    }
}
