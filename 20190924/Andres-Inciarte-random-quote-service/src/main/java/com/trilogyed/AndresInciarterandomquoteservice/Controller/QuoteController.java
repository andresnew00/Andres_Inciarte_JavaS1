package com.trilogyed.AndresInciarterandomquoteservice.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteController {

    //   URI: /quote
    //   HTTP Method: GET
    //   Request Body: None
    //   Response Body: Quote (String)
    @Value("${quote1}")
    private String quote1;
    @Value("${quote2}")
    private String quote2;
    @Value("${quote3}")
    private String quote3;
    @Value("${quote4}")
    private String quote4;
    @Value("${quote5}")
    private String quote5;
    @Value("${quote6}")
    private String quote6;
    @Value("${quote7}")
    private String quote7;
    @Value("${quote8}")
    private String quote8;



    @GetMapping(value = "/quote")
    public String getRandomQuote() {
        Random random = new Random();
        int randomNum = random.nextInt((7 - 1) + 1) + 1;
        ArrayList<String> quoteList = new ArrayList<>();
        quoteList.add(quote1);
        quoteList.add(quote2);
        quoteList.add(quote3);
        quoteList.add(quote4);
        quoteList.add(quote5);
        quoteList.add(quote6);
        quoteList.add(quote7);
        quoteList.add(quote8);

        return quoteList.get(randomNum);
    }

}
