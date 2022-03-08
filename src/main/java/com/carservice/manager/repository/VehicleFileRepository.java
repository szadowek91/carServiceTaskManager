package com.carservice.manager.repository;

import com.carservice.manager.entity.VehicleEntity;
import com.carservice.manager.model.VehicleModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class VehicleFileRepository {


    private VehicleModel vehicleModel;

    public List<VehicleModel> getVehicleModels(String fileName) {
        return readDataFromFile(fileName);
    }


    public void addVehicle(VehicleModel vehicleModel, String fileName) {
        List<VehicleModel> vehicleModels = readDataFromFile(fileName);
        vehicleModels.add(vehicleModel);
        saveJson(vehicleModels, fileName);

    }

    public void addAll(List<VehicleModel> vehicleModel, String fileName) {
        saveJson(vehicleModel, fileName);
    }


    private void saveJson(Object object, String fileName) {
        Gson gson = new Gson();
        try {
            try (FileWriter fw = new FileWriter(fileName + ".json")) {
                gson.toJson(object, fw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<VehicleModel> readDataFromFile(String fileName) {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName + ".json"))) {
            Type vehicleType = new TypeToken<ArrayList<VehicleModel>>() {
            }.getType();
            List<VehicleModel> vehicleModels = gson.fromJson(reader, vehicleType);
            return vehicleModels == null ? new ArrayList<>() : vehicleModels;
        } catch (IOException e) {
//            e.printStackTrace(); // don't want to print, because it's expected error (when file doesn't exist)
        }
        return new ArrayList<>();
    }
}