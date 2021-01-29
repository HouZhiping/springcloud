package com.zhongli.suxue.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师信息
 * </p>
 *
 * @author h
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("shuxue_teacher_info")
public class TeacherPo extends mapper {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long school_id;

    private String name;

    /**
     * 年龄
     */
    private Integer age;

    private String gender;

    private Integer popularity;

    private String avatar;

    private String description;

    /**
     * 年龄是否保密
     */
    private Integer age_show;

    private LocalDateTime create_time;

    /**
     * 排序
     */
    private Integer order_num;

    private String course;


}
