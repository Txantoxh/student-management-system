package com.student.management.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class StudentResponse {

    @Schema(description = "Student ID", example = "1")
    private Long id;

    @Schema(description = "Student full name", example = "Santosh")
    private String name;

    @Schema(description = "Student age", example = "25")
    private Integer age;

    @Schema(description = "Course name", example = "Computer Science")
    private String course;

    // No-args constructor for Jackson
    public StudentResponse() {}

    // All-args constructor
    public StudentResponse(Long id, String name, Integer age, String course) {
        this.id = id;  // ✅ FIXED - was this.id = this.id
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters (REQUIRED for Jackson serialization)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // Setters (optional but good practice)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
