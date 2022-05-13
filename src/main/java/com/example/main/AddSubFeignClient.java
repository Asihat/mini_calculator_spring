package com.example.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "Addandsubfeignclient", url = "http://localhost:8081")
public interface AddSubFeignClient {

    @GetMapping("/add")
    String clientAddResponse(@RequestParam(name = "first", required = true) String first,
                             @RequestParam(name = "second", required = true) String second);
    @GetMapping("/sub")
    String clientSubResponse(@RequestParam(name = "first", required = true) String first,
                             @RequestParam(name = "second", required = true) String second);
}
