package com.example.crawler.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Course {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private String courseType;
    private String courseDifficulty;
    private String coursePlatform;
    private String courseUrl;
    private String courseImageUrl;
    private BigDecimal coursePrice;
    private Boolean courseIsFree;
} 