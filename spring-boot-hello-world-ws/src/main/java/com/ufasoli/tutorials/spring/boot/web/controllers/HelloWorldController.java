package com.ufasoli.tutorials.spring.boot.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 04.02.14
 * Time: 15:33
 */
@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    @RequestMapping
    public String sayHello(){
        return "Hello World";
    }
}
