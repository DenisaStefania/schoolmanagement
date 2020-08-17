package com.frequentis.training.operations;

import com.frequentis.training.course.Course;
import com.frequentis.training.course.Grade;
import com.frequentis.training.repository.SchoolRepository;
import com.frequentis.training.people.Student;
import com.frequentis.training.people.Teacher;

import java.util.ArrayList;
import java.util.List;


public class TeacherOperations {
    public static void teachCourse(Teacher teacher, Course course) {
        if (CourseChecking.checkIfTaughtBySomeone(course)) {
            System.out.println("Someone else is already teaching this course!");
        } else {
            SchoolRepository.getCourseTeacherMap().put(course, teacher);
            System.out.println("You are now teaching " + course.getName());
        }
    }

    public static void gradeStudent(Course course, Student student, int gradePoints) {
        boolean studentWasGraded = StudentChecking.checkIfGraded(student, course);
        if (studentWasGraded) {
            System.out.println(student.getName() + " already received a grade for " + course.getName());
        } else {
            boolean courseHasGrades = CourseChecking.checkIfItHasGrades(course);
            if(courseHasGrades) {
                Grade grade = new Grade(gradePoints, student.getName());
                SchoolRepository.getGrades().get(course).add(grade);
            } else {
                List<Grade> grades = new ArrayList<>();
                Grade grade = new Grade(gradePoints, student.getName());
                grades.add(grade);
                SchoolRepository.getGrades().put(course, grades);
            }
        }
    }

    public static void defineCurricula(String curricula, Course course) {
        for (Course c : SchoolRepository.getCourses()) {
            if (c.getName().equals(course.getName())) {
                if (c.getCurricula().equals("")) {
                    c.setCurricula(curricula);
                } else {
                    System.out.println("Curricula for " + course.getName() + " is already defined!");
                }
            }
        }
    }

}
