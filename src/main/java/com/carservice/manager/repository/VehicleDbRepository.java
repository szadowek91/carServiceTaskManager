package com.carservice.manager.repository;

import com.carservice.manager.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDbRepository extends JpaRepository<VehicleEntity, Long> {


    List<VehicleEntity> findAllByMarkContainingIgnoreCaseOrModelContainingIgnoreCaseOrRegistrationNumberContainingIgnoreCase(
            String mark, String model, String registrationNumber);

    List<VehicleEntity> findAllByStatusEquals(boolean status);

}
