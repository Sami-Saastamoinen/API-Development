package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    //localhost:8080/somerandomURLthatdoesnotmeananything
    @GetMapping("*")
    public String redirect(){
        System.out.println("redirect()");
        return "redirect:/";
    }
}
