package com.hou.cd.controller;

import com.hou.cd.entity.Res;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("/greeting")
    public Res<String> greeting() {
        return Res.success("Hello, I am cd-app from person");
    }


}
