package com.trilogyed.AndresInciarterandomquoteservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${randomAnswerServiceName}")
    private String randomAnswerServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    //==========

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

    @GetMapping(value = "/answerme")
    public String getBallAnswer() {
        List<ServiceInstance> instances = discoveryClient.getInstances(randomAnswerServiceName);

        String randomAnswerServiceUri =
                serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String ballAnswer = restTemplate.getForObject(randomAnswerServiceUri, String.class);

        return ballAnswer;
    }

}
