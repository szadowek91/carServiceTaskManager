package com.carservice.manager.service;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleFileRepository;
import com.carservice.manager.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Validated
@Service
public class VehicleFileService {

    private VehicleFileRepository vehicleFileRepository;

    public VehicleFileService(VehicleFileRepository vehicleFileRepository) {
        this.vehicleFileRepository = vehicleFileRepository;
    }


    public void addVehicle(VehicleModel vehicleModel, String fileName) {
        vehicleModel.setId(Long.valueOf(UUID.randomUUID().hashCode()));
        vehicleModel.setAdmissionDate(new Date());
        vehicleFileRepository.addVehicle(vehicleModel, fileName);
    }

    public List<VehicleModel> getVehicleModels(String fileName) {
        return vehicleFileRepository.getVehicleModels(fileName);
    }

    public void addAllVehicles(List<VehicleModel> listVM, String fileName) {
        vehicleFileRepository.addAll(listVM, fileName);
    }

    public List<VehicleModel> findAllByInput(String input) {
        return vehicleFileRepository.getVehicleModels("main").stream()
                .filter
                        (i -> i.getMark().toUpperCase().contains(input.toUpperCase())
                                || i.getModel().toUpperCase().contains(input.toUpperCase())
                                || i.getRegistrationNumber().toUpperCase().contains(input.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<VehicleModel> findCarsBeforeRepair() {
        return vehicleFileRepository.getVehicleModels("main").stream().filter(VehicleModel -> !VehicleModel.isStatus()).collect(Collectors.toList());
    }

    public List<VehicleModel> findCarsAfterRepair() {
        return vehicleFileRepository.getVehicleModels("main").stream().filter(VehicleModel::isStatus).collect(Collectors.toList());
    }


    public void repair(int id) {
        String fileNameForFixed = DateUtils.stringDate(new Date()) + "_fixed";
        List<VehicleModel> vehicleModels = getVehicleModels(fileNameForFixed);
        List<VehicleModel> vehicleModelsAll = getVehicleModels("main");
        VehicleModel vehicleModel = vehicleModelsAll.stream().filter(c -> c.getId() == id).findFirst().get();
        vehicleModel.setStatus(true);
        vehicleModel.setRepairDate(new Date());
        vehicleModels.add(vehicleModel);
        addAllVehicles(vehicleModels, fileNameForFixed);
        addAllVehicles(vehicleModelsAll, "main");
    }
}