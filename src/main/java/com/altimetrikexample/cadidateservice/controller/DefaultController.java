package com.altimetrikexample.cadidateservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DefaultController {

    @GetMapping("/")
    String startService(){
        return "This is message from candidate service application.";
    }

    @GetMapping("/start")
    String start01Service(){
        return "This is alternate message from candidate service application.";
    }
}
