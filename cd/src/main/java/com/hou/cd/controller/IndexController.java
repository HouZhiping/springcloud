package com.hou.cd.controller;

import com.hou.cd.entity.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cd/index")
@RefreshScope
@Slf4j
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

    @RequestMapping("/greeting")
    public Res<String> greeting() {
        return Res.success("Hello, I am cd-app");
    }

    @GetMapping("/log")
    public Res<String> log(){

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        return Res.success("Hello, I am log");
    }











}
