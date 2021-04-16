package com.hou.gy.controller;

import com.hou.gy.entity.Res;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"5-buttonManage"})
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


    @ApiOperation(value = "1.getUseLocalCache")
    @RequestMapping("/get")
    public Res<Boolean> get() {
        return Res.success(useLocalCache);
    }

    @RequestMapping("/greeting")
    public Res<String> greeting() {
        return Res.success("Hello, I am gy-app");
    }


    public static void main(String[] args) {

    }







}
