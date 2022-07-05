package com.student1.CRUD.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

    @RequestMapping("/abc123")
    public String index() {
        return "index";
    }
}