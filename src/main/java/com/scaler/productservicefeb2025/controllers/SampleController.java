package com.scaler.productservicefeb2025.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Rest + controller -> Http APIs
@RequestMapping("/random")
public class SampleController {
//    http://localhost:8080/random/hello
    @GetMapping("/hello/{numOfTimes}") //http://localhost:8080/random/hello/8
    public String sayHello(@PathVariable("numOfTimes") int numOfTimes){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<numOfTimes;i++){
            sb.append("Hello Everyone !! \n");
        }
        return sb.toString();
    }
//    --http://localhost:8080/random/bye
    @GetMapping("/bye")
    public String sayBye(){
        return "Bye Everyone";
    }
}
