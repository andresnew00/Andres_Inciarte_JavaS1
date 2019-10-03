package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO need to create the properties
@FeignClient(name = "adserver-service")
public interface AdServiceClient {

    @GetMapping(value = "/ad")
    String getAd();
}
