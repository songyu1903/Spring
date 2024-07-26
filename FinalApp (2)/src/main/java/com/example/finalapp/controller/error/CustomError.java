package com.example.finalapp.controller.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomError implements ErrorController {
    @GetMapping("/error")
    public String error(HttpServletRequest req) {
//       HTTP 상태 코드를 req에게 받을 수 있다.
        Object attribute = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(attribute != null) {
            Integer statusCode = (Integer) attribute;

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404";
            }
        }

        return "error/500";
    }
}
