package com.carservice.manager.controller;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.stream.Collectors;


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
        model.addAttribute("cars", vehicleService.getVehicleModels("main"));
        model.addAttribute("time", true);
        return "cars";
    }

    @GetMapping("/add")
    public String addCar(Model model, VehicleModel vehicleModel) {
        model.addAttribute("vehicleModel", vehicleModel);
        return "add";
    }

    @PostMapping("/add")
    public String addCar(@Valid VehicleModel vehicleModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.joining("\n")));
            return "add";
        }
        vehicleService.addVehicle(vehicleModel, "main");
        return "redirect:/cars";
    }

    @PostMapping("/repair")
    public String repairCar(@RequestParam("id") int id) {

        vehicleService.repair(id);
        return "redirect:/cars";
    }

    @GetMapping("/search")
    public String findAllByInput(Model model, @RequestParam("text") String input) {
        model.addAttribute("cars", vehicleService.findAllByInput(input));
        model.addAttribute("time", false);
        return "cars";
    }

    @GetMapping("/beforeRepair")
    public String findCarsBeforeRepair(Model model) {
        model.addAttribute("cars", vehicleService.findCarsBeforeRepair());
        model.addAttribute("time", true);
        return "cars";
    }

    @GetMapping("/afterRepair")
    public String findCarsAfterRepair(Model model) {
        model.addAttribute("cars", vehicleService.findCarsAfterRepair());
        model.addAttribute("time", false);
        return "cars";
    }

}