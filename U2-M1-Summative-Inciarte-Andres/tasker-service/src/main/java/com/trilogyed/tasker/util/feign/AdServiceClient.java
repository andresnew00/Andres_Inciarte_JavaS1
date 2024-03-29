package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "adserver-service")
public interface AdServiceClient {

    @GetMapping(value = "/ad")
    String getAd();
}
