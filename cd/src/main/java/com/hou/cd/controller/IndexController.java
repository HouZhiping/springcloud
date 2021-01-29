package com.hou.cd.controller;

import com.hou.cd.entity.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cd/index")
public class IndexController {


    @GetMapping("test")
    public Res<String> index(){
        return Res.success("index");
    }



}
