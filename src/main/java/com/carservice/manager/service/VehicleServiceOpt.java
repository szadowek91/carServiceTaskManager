//package com.carservice.manager.service;

//import com.carservice.manager.mapper.VehicleMapper;

//
//@Service
//public class VehicleServiceOpt {
//
//    private final VehicleRepository vehicleRepository;
//    private final VehicleMapper vehicleMapper;
//
//
//    public VehicleServiceOpt (VehicleRepository vehicleRepository, VehicleMapper vehicleMapper){
//        this.vehicleMapper = vehicleMapper;
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    public VehicleModel save(VehicleDto vehicleDto){
//        return vehicleRepository.save(vehicleMapper.toEntity(vehicleDto));
//    }
//
//    public void deleteById (Long id){
//        vehicleRepository.findById(id).ifPresentOrElse(vehicleRepository::delete,()->{
//            throw (new ExceptionService(id));
//        });
//    }
//
//
//}
