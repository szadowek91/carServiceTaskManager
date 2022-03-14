package com.carservice.manager.controller;

import com.carservice.manager.config.Log4J2YamlConfig;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandlingController implements ErrorController {

    Log4J2YamlConfig logger = new Log4J2YamlConfig();

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        logger.infoLogEnterIntoMethod("handleError");

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        logger.errorLog("handleError // Website can not be displayed");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                logger.errorLog("Not Found 404");
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                logger.errorLog("Internal server 500");
                return "error-500";
            }
        }
        return "error";
    }
}
