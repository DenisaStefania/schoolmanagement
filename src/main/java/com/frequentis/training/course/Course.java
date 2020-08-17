package com.frequentis.training.course;

public class Course {
    private String name;
    private String curricula;

    public Course(String name) {
        this.name = name;
        this.curricula = "";
    }

    public String getName() {
        return name;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }
}
