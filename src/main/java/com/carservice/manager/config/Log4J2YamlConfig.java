package com.carservice.manager.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cglib.core.ClassNameReader;

public class Log4J2YamlConfig {

    private Logger logger = LogManager.getLogger();

    public void performSomeTask() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }

    public void infoLogEnterIntoMethod(String methodName){
        logger.info("Enter into " + methodName + " method.");
    }

    public void infoLogSuccess(){
        logger.info("Done successfully.");
    }

    public void errorLog(String errorName){
        logger.error("something goes wrong ! : " + errorName);
    }

    public void fatalLog(String fatalErrorName){
        logger.fatal(fatalErrorName + "  == FATAL ERROR, contact with support: 666-666-666");
    }
}
