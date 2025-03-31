package com.eduassistant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_courses")
public class UserCourse {
    @TableId(type = IdType.AUTO)
    private Integer userCourseId;
    private Integer userId;
    private Integer courseId;
    private Date enrollmentDate;
    private Double progress;
}