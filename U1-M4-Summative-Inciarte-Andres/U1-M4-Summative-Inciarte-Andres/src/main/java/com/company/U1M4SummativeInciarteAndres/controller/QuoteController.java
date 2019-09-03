package com.company.U1M4SummativeInciarteAndres.controller;

import com.company.U1M4SummativeInciarteAndres.model.Quote;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class QuoteController {

    static ArrayList<Quote> quotes = new ArrayList<>();
    static {
        quotes.add(new Quote("Better to remain silent and be thought a fool than to speak out and remove all doubt."
                , "– Abraham Lincoln"));
        quotes.add(new Quote("If I were two-faced, would I be wearing this one?",
                "– Abraham Lincoln"));
        quotes.add(new Quote("The only mystery in life is why the kamikaze pilots wore helmets.",
                "– Al McGuire"));
        quotes.add(new Quote("The best thing about the future is that it comes one day at a time.",
                "– Abraham Lincoln"));
        quotes.add(new Quote("Light travels faster than sound. This is why some people appear bright until you hear them speak.",
                "– Alan Dundes"));
        quotes.add(new Quote("Nobody realizes that some people expend tremendous energy merely to be normal.",
                "– Albert Camus"));
        quotes.add(new Quote("Men marry women with the hope they will never change. Women marry men with the hope they will change. Invariably they are both disappointed.",
                "– Albert Einstein"));
        quotes.add(new Quote("The difference between stupidity and genius is that genius has its limits.",
                "– Albert Einstein"));
        quotes.add(new Quote("All the things I really like to do are either immoral, illegal or fattening.",
                "– Alexander Woollcott"));
        quotes.add(new Quote("War is God’s way of teaching Americans geography.",
                "– Ambrose Bierce"));
        // TODO keep ading to the list and then create a randomizer for these
    }

    @GetMapping(value = "/quote")
    @ResponseStatus(value = HttpStatus.OK)
    public Quote giveMeaQuote() {

        Random random = new Random();
        Quote myQuote = quotes.get(random.nextInt(quotes.size()));
        return myQuote;
    }
}


