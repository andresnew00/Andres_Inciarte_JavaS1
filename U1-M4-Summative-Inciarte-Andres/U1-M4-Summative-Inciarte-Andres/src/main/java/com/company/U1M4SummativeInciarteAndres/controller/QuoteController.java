package com.company.U1M4SummativeInciarteAndres.controller;

import com.company.U1M4SummativeInciarteAndres.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class QuoteController {

    @GetMapping(value = "/quote")
    @ResponseStatus(value = HttpStatus.OK)
    public Quote giveMeaQuote() {

        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        Quote myQuote = new Quote();

        switch (randomNumber){

            case 1:
                myQuote.setQuote("Better to remain silent and be thought a fool than to speak out and remove all doubt.");
                myQuote.setAuthor("– Abraham Lincoln");
                return myQuote;
            case 2:
                myQuote.setQuote("If I were two-faced, would I be wearing this one?");
                myQuote.setAuthor("– Abraham Lincoln");
                return myQuote;
            case 3:
                myQuote.setQuote("The best thing about the future is that it comes one day at a time.");
                myQuote.setAuthor("– Abraham Lincoln");
                return myQuote;
            case 4:
                myQuote.setQuote("The only mystery in life is why the kamikaze pilots wore helmets.");
                myQuote.setAuthor("– Al McGuire");
                return myQuote;
            case 5:
                myQuote.setQuote("Light travels faster than sound. This is why some people appear bright until you hear them speak.");
                myQuote.setAuthor("– Alan Dundes");
                return myQuote;
            case 6:
                myQuote.setQuote("Nobody realizes that some people expend tremendous energy merely to be normal.");
                myQuote.setAuthor("– Albert Camus");
                return myQuote;
            case 7:
                myQuote.setQuote("Men marry women with the hope they will never change. Women marry men with the hope they will change. Invariably they are both disappointed.");
                myQuote.setAuthor("– Albert Einstein");
                return myQuote;
            case 8:
                myQuote.setQuote("The difference between stupidity and genius is that genius has its limits.");
                myQuote.setAuthor("– Albert Einstein");
                return myQuote;
            case 9:
                myQuote.setQuote("All the things I really like to do are either immoral, illegal or fattening.");
                myQuote.setAuthor("– Alexander Woollcott");
                return myQuote;
            case 10:
                myQuote.setQuote("War is God’s way of teaching Americans geography.");
                myQuote.setAuthor("– Ambrose Bierce");
                default:
                    throw new NumberFormatException();
        }
    }
}

