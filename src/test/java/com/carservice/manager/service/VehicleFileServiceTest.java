package com.carservice.manager.service;

import com.carservice.manager.model.VehicleModel;
import com.carservice.manager.repository.VehicleFileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class VehicleFileServiceTest {

    private List<VehicleModel> listOfCars = new ArrayList<>();

    @InjectMocks
    private VehicleFileService vehicleFileService;

    @Mock
    private VehicleFileRepository vehicleFileRepository;

    int plusOneDay = +(1000 * 60 * 60 * 24);
    int minusOneDay = -(1000 * 60 * 60 * 24);

    @BeforeEach
    void setUp() {
        listOfCars.add(new VehicleModel("GD 9090", "Audi", "A4", "black", 1999, new Date(), new Date(plusOneDay), false));
        listOfCars.add(new VehicleModel("GD 3030", "BMW", "5", "black", 2001, new Date(), new Date(plusOneDay * 2), false));
        listOfCars.add(new VehicleModel("GD 9090", "Citroen", "C5", "white", 2006, new Date(), new Date(plusOneDay), false));
        listOfCars.add(new VehicleModel("GD 9090", "Dodge", "Ram", "red", 2004, new Date(), new Date(plusOneDay), false));
        listOfCars.add(new VehicleModel("GD 9090", "Ford", "Focus", "pink", 2021, new Date(), new Date(plusOneDay), false));
        listOfCars.add(new VehicleModel("GD 9090", "Honda", "Accord", "grey", 1984, new Date(), new Date(plusOneDay), false));
        listOfCars.add(new VehicleModel("GD 9090", "Honda", "Accord", "grey", 1984, new Date(minusOneDay), new Date(), true));
        listOfCars.add(new VehicleModel("GD 9090", "Honda", "Accord", "grey", 1984, new Date(minusOneDay * 3), new Date(minusOneDay), true));

    }

    private List<VehicleModel> listOfCars() {
        return listOfCars;
    }

    @AfterEach
    void clean() {
        listOfCars.clear();
    }


    // =================================== FILE SERVICE TESTS ========================================== \\


    @Test
    void addVehicle() {
        //given
        //when
        //then
    }

    @Test
    void getVehicleModels() {
        //given
        //when
        //then
    }

    @Test
    void addAllVehicles() {
        //given
        //when
        //then
    }

    @Test
    void findAllByInput() {
        //given
        //when
        //then
    }

    @Test
    void findCarsBeforeRepair() {
        //given
        //when
        //then
    }

    @Test
    void findCarsAfterRepair() {
        //given
        //when
        //then
    }

    @Test
    void repair() {
        //given
        //when
        //then
    }
}