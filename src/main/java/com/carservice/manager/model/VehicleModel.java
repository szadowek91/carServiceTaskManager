package com.carservice.manager.model;

import java.time.LocalDate;
import java.util.Date;

public class VehicleModel {

    private int id;
    private String registrationNumber;
    private String mark;
    private String model;
    private String color;
    private int productionYear;
    private Date admissionDate;
    private boolean status = false;



    public VehicleModel(int id, String registrationNumber, String mark, String model, String color, int productionYear, Date admissionDate, boolean status) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public VehicleModel(String registrationNumber, String mark, String model, String color, int productionYear, Date admissionDate, boolean status) {
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public VehicleModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                ", admissionDate=" + admissionDate +
                ", status=" + status +
                '}';
    }
}


