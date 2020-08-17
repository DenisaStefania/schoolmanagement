package com.frequentis.training.people;

import com.frequentis.training.course.Course;
import com.frequentis.training.operations.TeacherOperations;


public class Teacher extends Individual {

    public Teacher(PersonalData personalData) {
        super(personalData);
    }

    public void teachCourse(Course course) {
        TeacherOperations.teachCourse(this, course);
    }

    public void gradeStudent(Course course, Student student, int gradePoints) {
        TeacherOperations.gradeStudent(course, student, gradePoints);
    }

    public void defineCurricula(String curricula, Course course) {
        TeacherOperations.defineCurricula(curricula, course);
    }
}
