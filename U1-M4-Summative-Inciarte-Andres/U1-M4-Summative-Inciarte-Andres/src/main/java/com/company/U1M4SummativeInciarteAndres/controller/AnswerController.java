package com.company.U1M4SummativeInciarteAndres.controller;

import com.company.U1M4SummativeInciarteAndres.model.Answer;
import com.company.U1M4SummativeInciarteAndres.model.Definition;
import com.company.U1M4SummativeInciarteAndres.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class AnswerController {

    Map<String, String> mymap = new HashMap<>();


    @PostMapping(value = "/magic")
    @ResponseStatus(value = HttpStatus.OK)
    public Answer magicball(@RequestBody @Valid Answer answer) {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        Answer myAnswer = new Answer();

        switch (randomNumber) {

            case 1:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("yes.");
                return myAnswer;
            case 2:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("no.");
                return myAnswer;
            case 3:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("ask again later.");
                return myAnswer;
            case 4:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("maybe.");
                return myAnswer;
            case 5:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("sure, why not?");
                return myAnswer;
            case 6:
                myAnswer.setQuestion(answer.getQuestion());
                myAnswer.setAnswer("sounds crazy but I'm into it.");
                return myAnswer;
            default:
                throw new NumberFormatException();
        }
    }
}
