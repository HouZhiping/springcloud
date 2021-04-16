package com.hou.cd.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.hou.cd.entity.Res;
import com.hou.cd.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Api(tags={"5-nacos模块"})
@RestController
@RequestMapping("/nacos")
public class NacosConfigController {


    @Value("${cd.user.name}")
    String userName;


    @ApiOperation(value = "1、getUser")
    @ApiOperationSupport(order = 1,includeParameters = {"user.id"})
    @PostMapping("/getUser")
    public Res<User> findById(@RequestBody User user){
        user.setName(userName);
        user.setAge(31);
        return Res.success(user);
    }







}
