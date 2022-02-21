package com.carservice.manager.repository;

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
import java.util.List;

@Repository
public class VehicleRepository {


    public List<VehicleModel> getVehicleModels() {
        return readDataFromFile();
    }


    public void addVehicle(VehicleModel vehicleModel) {
        saveDataToFile(vehicleModel);
    }


    private void saveDataToFile(VehicleModel vehicleModel) {
        Gson gson = new Gson();
        List<VehicleModel> vehicleModels = readDataFromFile();
        vehicleModels.add(vehicleModel);
        try {
            try (FileWriter fw = new FileWriter("main.json")) {
                gson.toJson(vehicleModels, fw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<VehicleModel> readDataFromFile() {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get("main.json"))) {
            Type vehicleType = new TypeToken<ArrayList<VehicleModel>>() {
            }.getType();
            return gson.fromJson(reader, vehicleType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
