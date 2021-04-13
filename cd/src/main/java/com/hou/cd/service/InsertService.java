package com.hou.cd.service;

import com.hou.cd.entity.User;

import java.util.Collection;

public interface InsertService {
    User insert();

    Collection<User> insertMany();
}
