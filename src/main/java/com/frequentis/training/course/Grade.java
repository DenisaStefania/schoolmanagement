package com.frequentis.training.course;

public class Grade {
    private int gradePoints;
    private String studentName;

    public Grade(int gradePoints, String studentName) {
        this.gradePoints = gradePoints;
        this.studentName = studentName;
    }

    public int getGradePoints() {
        return gradePoints;
    }

    public String getStudentName() {
        return studentName;
    }
}
