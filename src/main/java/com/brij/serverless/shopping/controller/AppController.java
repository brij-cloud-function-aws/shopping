package com.brij.serverless.shopping.controller;

import com.brij.serverless.shopping.function.StringReverseFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
This controller is only for time being , see how can we call the functions during development

 */
@RestController
public class AppController {

    @Autowired
    StringReverseFunction function;
    @GetMapping("/reverseme/{input}")
    public String reverseString(@PathVariable(value = "input")String input){
        return function.apply(input);
    }
}
