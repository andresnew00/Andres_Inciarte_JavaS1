package com.company.firstnamelastnamemagiceightballservice.Controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicBallController {

    private List<String> magicBallAnswers = new ArrayList<>();

    private Random random = new Random();

    public MagicBallController() {
        magicBallAnswers.add("No");
        magicBallAnswers.add("Yes");
        magicBallAnswers.add("Looking");
        magicBallAnswers.add("Not sure");
        magicBallAnswers.add("Absolutely!");
        magicBallAnswers.add("Ask again");
        magicBallAnswers.add("Ummm");
        magicBallAnswers.add("Not a chance");
    }

    @GetMapping(value = "/eightballanswer")
    public String getRandomAnswer(){
        int randomAnswer = random.nextInt(8);
        return magicBallAnswers.get(randomAnswer);
    }

}
