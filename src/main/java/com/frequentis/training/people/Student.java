package com.frequentis.training.people;

import com.frequentis.training.course.Course;
import com.frequentis.training.operations.StudentOperations;

public class Student extends Individual {

    public Student(PersonalData personalData) {
        super(personalData);
    }

    public String getName(){
        return this.personalData.getName();
    }

    public void enrollToCourse(Course course) {
        StudentOperations.enroll(this, course);
    }

    public void attendCourse(Course course, int courseSessionNumber) {
        StudentOperations.attend(this, course, courseSessionNumber);
    }

    public void checkGrade(Course course) {
        StudentOperations.checkGrade(this, course);
    }
}
