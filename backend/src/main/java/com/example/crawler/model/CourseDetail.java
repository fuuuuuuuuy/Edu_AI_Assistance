package com.example.crawler.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseDetail {
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
    private List<String> courseTags;
    private String courseInstructor;
    private String courseInstitution;
    private String courseLanguage;
    private Integer courseDuration;
    private String courseSchedule;
    private String coursePrerequisites;
    private String courseObjectives;
    private String courseSyllabus;
} 