package com.student.management.dto;

import lombok.Data;

@Data
public class StudentPatchRequest {
    private String name;
    private Integer age;
    private String course;
}
