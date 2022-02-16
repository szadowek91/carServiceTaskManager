package com.carservice.manager.utils;

public class ExceptionService extends RuntimeException{

    public ExceptionService(Long id){
        super ("Can not find vehicle with selected id: " + id);
    }

}
