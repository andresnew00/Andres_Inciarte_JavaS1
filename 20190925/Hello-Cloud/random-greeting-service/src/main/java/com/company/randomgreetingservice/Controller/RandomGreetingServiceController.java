package com.company.randomgreetingservice.Controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomGreetingServiceController {

    private List<String> greetingList = new ArrayList<>();

    private Random random = new Random();

    public RandomGreetingServiceController() {
        greetingList.add("Hello");
        greetingList.add("Hii");
        greetingList.add("Holaa");
        greetingList.add("no");
        greetingList.add("sorry");
    }

    @GetMapping(value = "/greeting")
    public String getRandomGreeting(){
        int whichGreeting = random.nextInt(5);
        return greetingList.get(whichGreeting);
    }
}
