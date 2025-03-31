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
@TableName("courses")
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private String courseType;
    private String courseDifficulty;
    private String coursePlatform;
    private String courseUrl;
    private String courseImageUrl;
    private Double coursePrice;
    private Boolean courseIsFree;
    private Date createdAt;
    private Date updatedAt;
}