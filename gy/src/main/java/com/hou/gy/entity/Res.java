package com.hou.gy.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Res<T> {


    private int code = 200;

    /**
     * 返回查询数据
     */
    private T  data;

    /**
     * 是否成功
     */
    private boolean status = true;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private LocalDateTime timestamp = LocalDateTime.now();


    public static <T>Res<T> success( T data) {
        Res<T> res = new Res<>();
        res.setData(data);
        return res;
    }




}
