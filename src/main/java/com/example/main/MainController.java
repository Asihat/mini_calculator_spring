package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private AddSubFeignClient addSubFeignClient;
    @Autowired
    private MulAndDivFeignClient mulAndDivFeignClient;

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("result", "Enter data click buttons");
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "first", required = true) String first,
                      @RequestParam(name = "second", required = true) String second,
                      Model model
    ) {
        String result = addSubFeignClient.clientAddResponse(first, second);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam(name = "first", required = true) String first,
                      @RequestParam(name = "second", required = true) String second,
                      Model model
    ) {
        String result = addSubFeignClient.clientSubResponse(first, second);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/mul")
    public String mul(@RequestParam(name = "first", required = true) String first,
                      @RequestParam(name = "second", required = true) String second,
                      Model model
    ) {
        String result = mulAndDivFeignClient.clientMulResponse(first, second);
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping("/div")
    public String div(@RequestParam(name = "first", required = true) String first,
                      @RequestParam(name = "second", required = true) String second,
                      Model model
    ) {
        String result = mulAndDivFeignClient.clientDivResponse(first, second);
        model.addAttribute("result", result);
        return "index";
    }
}