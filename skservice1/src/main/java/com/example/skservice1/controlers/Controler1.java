package com.example.skservice1.controlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controler1 {

    private final RestTemplate restTemplate;

    @GetMapping("/hello/{caller}")
    public String hello(@PathVariable String caller) {
        log.info("Log:: Hi to " + caller + " from skservice1");
        return "Hi to " + caller + " from skservice1";
    }

    @GetMapping("/hopper/{caller}")
    public String hopper(@PathVariable String caller) {
        log.info("Log:: Hi to " + caller + " from hopper of skservice1");
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/hello/skservice1", HttpMethod.GET, null, String.class);
        log.info("Got the response from skservice2: {}", response.getBody());
        return "response from skservice2 is: " + response.getBody();
    }

}
