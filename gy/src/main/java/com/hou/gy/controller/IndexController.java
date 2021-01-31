package com.hou.gy.controller;

import com.hou.cd.entity.Res;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@RefreshScope
public class IndexController {


    @GetMapping("test")
    public Res<String> index(){
        return Res.success("index");
    }

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;


    @RequestMapping("/get")
    public Res<Boolean> get() {
        return Res.success(useLocalCache);
    }







}
