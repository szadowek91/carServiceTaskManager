package com.carservice.manager.repository;

import com.carservice.manager.model.VehicleModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {


    private List<VehicleModel> vehicleModels;


    public VehicleRepository() {
        vehicleModels = new ArrayList<>();
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }


    public void addVehicle(VehicleModel vehicleModel) {
        vehicleModels.add(vehicleModel);

        saveDataToFile(vehicleModel);
    }


    private void saveDataToFile(VehicleModel vehicleModel) {
        Gson gson = new Gson();

        try {
            try (FileWriter fw = new FileWriter("main.json")) {
                gson.toJson(vehicleModel, fw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VehicleModel readDataFromFile() {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get("main.json"))) {
            return gson.fromJson(reader, VehicleModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
