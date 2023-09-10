package com.altimetrikexample.cadidateservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/candidate")
@Slf4j
public class DefaultController {

    @GetMapping("/")
    String startService(){
        return "This is message from candidate service application.";
    }
}
