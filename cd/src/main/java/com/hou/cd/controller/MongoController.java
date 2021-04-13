package com.hou.cd.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.hou.cd.entity.Res;
import com.hou.cd.entity.User;
import com.hou.cd.service.InsertService;
import com.hou.cd.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags={"1-mongoManage"})
@RestController
@RequestMapping("/mongo")
@RefreshScope
public class MongoController {


    @Autowired
    private InsertService insertService;

    @Autowired
    private QueryService queryService;


    @GetMapping("/findAll")
    public Res<List<User>> findAll(){
        return Res.success(queryService.findAll());
    }


    @ApiOperation(value = "1、findById")
    @ApiOperationSupport(order = 1,includeParameters = {"user.id"})
    @PostMapping("/findById")
    public Res<User> findById(@RequestBody User user){
        return Res.success(queryService.findById(user.getId()));
    }











}
