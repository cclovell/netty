package com.cc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by chenghao on 3/7/17.
 */

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcomeGet(){
        return "Welcome,You!!!";
    }

}
