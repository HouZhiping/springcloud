package com.hou.cd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@ToString
@Accessors(chain = true)
public class User {


    /**
     * 使用 @MongoID 能更清晰的指定 _id 主键
     */
    @MongoId
    @ApiModelProperty(value="主键Id", required = true)
    private String id;
    private String name;
    private String sex;
    private Integer salary;
    private Integer age;
    @JsonFormat( pattern ="yyyy-MM-dd", timezone ="GMT+8")
    private LocalDate birthday;
    private String remake;
    private Status status;




}
