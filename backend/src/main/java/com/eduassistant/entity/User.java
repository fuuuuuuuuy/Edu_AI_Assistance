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
@TableName("users")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String userTelep;
    private String userEmail;
    private String userPassword;
    private String userRole;
    private Date createdAt;
    private Date updatedAt;
}