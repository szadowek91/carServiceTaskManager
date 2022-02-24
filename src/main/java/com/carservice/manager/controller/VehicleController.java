package com.carservice.manager.controller;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public String test() {
        return "Hello";
    }

    @GetMapping("/cars")
    public String carsView(Model model) {
        model.addAttribute("cars", vehicleService.getVehicleModels());
        return "cars";
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new VehicleModel());
        return "add";
    }

    @PostMapping("/add")
    public String addCar(VehicleModel vehicleModel) {
        vehicleService.addVehicle(vehicleModel);
        return "redirect:/cars";
    }

    @PostMapping("/repair")
    public String repairCar(@RequestParam("id") int id) {
        List<VehicleModel> vehicleModels = vehicleService.getVehicleModels();
        VehicleModel vehicleModel = vehicleModels.stream().filter(c -> c.getId() == id).findFirst().get();
        vehicleModel.setStatus(true);
        vehicleService.addAllVehicles(vehicleModels);
        return "redirect:/cars";
    }

    @GetMapping("/search")
    public String findAllByInput (Model model, @RequestParam("text") String input){
        model.addAttribute("cars", vehicleService.findAllByInput(input));
        return "cars";
    }

    @GetMapping("/beforeRepair")
    public String findCarsBeforeRepair(Model model){
        model.addAttribute("cars", vehicleService.findCarsBeforeRepair());
        return "cars";
    }

    @GetMapping("/afterRepair")
    public String findCarsAfterRepair(Model model){
        model.addAttribute("cars", vehicleService.findCarsAfterRepair());
        return "cars";
    }

}
