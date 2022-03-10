package com.carservice.manager.service;

import com.carservice.manager.config.Log4J2YamlConfig;
import org.junit.jupiter.api.Test;


// ===================================== LOGGER LOG4J2 TESTS ========================================== \\


public class LoggerTest {

    @Test
    public void testPerformSomeTask() throws Exception {
        Log4J2YamlConfig log4J2YamlConf = new Log4J2YamlConfig();
        log4J2YamlConf.performSomeTask();
    }
}
