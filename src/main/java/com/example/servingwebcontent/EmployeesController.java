package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeesController {

    @GetMapping("/employees")
    public String employees() {
        return "employees";
    }
}
