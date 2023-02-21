package com.rabinart.ems.http.controller;


import com.rabinart.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final EmployeeService employeeService;

    @GetMapping
    public String get(){
        return "registration";
    }


}
