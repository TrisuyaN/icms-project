package com.sc.scbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiDemoDevController {
    @GetMapping("apiDemo")
    public String apiDemo() {
        return "apiDemo: " +
                "";
    }
}
