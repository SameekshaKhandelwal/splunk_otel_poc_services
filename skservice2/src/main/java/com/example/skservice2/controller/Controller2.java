package com.example.skservice2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller2 {

    @GetMapping("/hello/{caller}")
    public String hello(@PathVariable String caller) {
        log.info("Log:: Hi to " + caller + " from skservice2");
        return "Hi to " + caller + " from skservice2";
    }

}
