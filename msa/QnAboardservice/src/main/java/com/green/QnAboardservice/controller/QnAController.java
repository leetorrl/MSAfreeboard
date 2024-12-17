package com.green.QnAboardservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QnAController {

    private final Environment environment;


    @GetMapping("/env")
    public String getnvironmentVariables(){
        return String.format("token.secret = %S", environment.getProperty("token.secret"));
    }

}
