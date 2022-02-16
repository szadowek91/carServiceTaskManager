package com.carservice.manager.model;


public class ServiceModelMain {

    private String carToRepair;
    private String addNewVehicle;
    private String repairCar;
    private String carsRepairedSuccessful;


    public ServiceModelMain(String carToRepair, String addNewVehicle, String repairCar, String carsRepairedSuccessful) {
        this.carToRepair = carToRepair;
        this.addNewVehicle = addNewVehicle;
        this.repairCar = repairCar;
        this.carsRepairedSuccessful = carsRepairedSuccessful;
    }

    public ServiceModelMain() {
    }

    public String getCarToRepair() {
        return carToRepair;
    }

    public void setCarToRepair(String carToRepair) {
        this.carToRepair = carToRepair;
    }

    public String getAddNewVehicle() {
        return addNewVehicle;
    }

    public void setAddNewVehicle(String addNewVehicle) {
        this.addNewVehicle = addNewVehicle;
    }

    public String getRepairCar() {
        return repairCar;
    }

    public void setRepairCar(String repairCar) {
        this.repairCar = repairCar;
    }

    public String getCarsRepairedSuccessful() {
        return carsRepairedSuccessful;
    }

    public void setCarsRepairedSuccessful(String carsRepairedSuccessful) {
        this.carsRepairedSuccessful = carsRepairedSuccessful;
    }

    @Override
    public String toString() {
        return "ServiceModelMain{" +
                "carToRepair='" + carToRepair + '\'' +
                ", addNewVehicle='" + addNewVehicle + '\'' +
                ", repairCar='" + repairCar + '\'' +
                ", carsRepairedSuccessful='" + carsRepairedSuccessful + '\'' +
                '}';
    }
}
