package com.example.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MulAndDivFeignClient", url = "http://localhost:8082")
public interface MulAndDivFeignClient {

    @GetMapping("/mul")
    String clientMulResponse(@RequestParam(name = "first", required = true) String first,
                             @RequestParam(name = "second", required = true) String second);
    @GetMapping("/div")
    String clientDivResponse(@RequestParam(name = "first", required = true) String first,
                             @RequestParam(name = "second", required = true) String second);
}
