package com.carservice.manager.service;

import com.carservice.manager.config.Log4J2YamlConfig;
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

    Log4J2YamlConfig logger = new Log4J2YamlConfig();


    public void addVehicle(VehicleModel vehicleModel, String fileName) {
        logger.infoLogEnterIntoMethod("addVehicle/FileService");
        vehicleModel.setId(Long.valueOf(UUID.randomUUID().hashCode()));
        vehicleModel.setAdmissionDate(new Date());
        vehicleFileRepository.addVehicle(vehicleModel, fileName);
        logger.infoLogSuccess();
    }

    public List<VehicleModel> getVehicleModels(String fileName) {
        logger.infoLogEnterIntoMethod("getVehicleModels/FileService");
        logger.infoLogSuccess();
        return vehicleFileRepository.getVehicleModels(fileName);
    }

    public void addAllVehicles(List<VehicleModel> listVM, String fileName) {
        logger.infoLogEnterIntoMethod("addAllVehicles/FileService");
        vehicleFileRepository.addAll(listVM, fileName);
        logger.infoLogSuccess();
    }

    public List<VehicleModel> findAllByInput(String input) {
        logger.infoLogEnterIntoMethod("findAllByInput/FileService");
        logger.infoLogSuccess();
        return vehicleFileRepository.getVehicleModels("main").stream()
                .filter
                        (i -> i.getMark().toUpperCase().contains(input.toUpperCase())
                                || i.getModel().toUpperCase().contains(input.toUpperCase())
                                || i.getRegistrationNumber().toUpperCase().contains(input.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<VehicleModel> findCarsBeforeRepair() {
        logger.infoLogEnterIntoMethod("findCarsBeforeRepair/FileService");
        logger.infoLogSuccess();
        return vehicleFileRepository.getVehicleModels("main").stream().filter(VehicleModel -> !VehicleModel.isStatus()).collect(Collectors.toList());
    }

    public List<VehicleModel> findCarsAfterRepair() {
        logger.infoLogEnterIntoMethod("findCarsAfterRepair/FileService");
        logger.infoLogSuccess();
        return vehicleFileRepository.getVehicleModels("main").stream().filter(VehicleModel::isStatus).collect(Collectors.toList());
    }


    public void repair(int id) {
        logger.infoLogEnterIntoMethod("repair/FileService");
        String fileNameForFixed = DateUtils.stringDate(new Date()) + "_fixed";
        List<VehicleModel> vehicleModels = getVehicleModels(fileNameForFixed);
        List<VehicleModel> vehicleModelsAll = getVehicleModels("main");
        VehicleModel vehicleModel = vehicleModelsAll.stream().filter(c -> c.getId() == id).findFirst().get();
        vehicleModel.setStatus(true);
        vehicleModel.setRepairDate(new Date());
        vehicleModels.add(vehicleModel);
        addAllVehicles(vehicleModels, fileNameForFixed);
        addAllVehicles(vehicleModelsAll, "main");
        logger.infoLogSuccess();
    }
}