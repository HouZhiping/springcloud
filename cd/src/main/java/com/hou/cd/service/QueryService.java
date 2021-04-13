package com.hou.cd.service;

import com.hou.cd.entity.User;

import java.util.List;

public interface QueryService {
    List<User> findAll();

    User findById(String userId);
}
