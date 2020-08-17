package com.frequentis.training.operations;

import com.frequentis.training.course.Course;
import com.frequentis.training.course.Grade;
import com.frequentis.training.repository.SchoolRepository;
import com.frequentis.training.people.Student;

import java.util.List;

public class StudentOperations {
    private static int getGrade(Student student, Course course) {
        List<Grade> grades = SchoolRepository.getGrades().get(course);
        for (Grade g : grades) {
            if (g.getStudentName().equals(student.getName())) {
                return g.getGradePoints();
            }
        }
        return -1; // no special value, this method will be called only if the student has been assigned a grade for the course
    }

    public static void enroll(Student student, Course course) {
        boolean isEnrolled = StudentChecking.checkEnrollmentStatus(student, course);
        if (isEnrolled) {
            System.out.println("You are already enrolled in " + course.getName());
        } else {
            SchoolRepository.getEnrollments().get(course).add(student);
            System.out.println("You enrolled in " + course.getName());
        }
    }

    public static void attend(Student student, Course course, int courseSessionNumber) {
        boolean studentHasEnrolled = StudentChecking.checkEnrollmentStatus(student, course);
        if (studentHasEnrolled) {
            boolean hasAttended = StudentChecking.checkAttendance(student, course, courseSessionNumber);
            if (hasAttended) {
                System.out.println("You have already attended session " + courseSessionNumber + " for " + course.getName());
            } else {
                SchoolRepository.getAttendances().get(course).get(courseSessionNumber).add(student);
                System.out.println("You attend session " + courseSessionNumber + " of " + course.getName());
            }
        } else {
            System.out.println("You cannot attend session " + courseSessionNumber +
                    " for course " + course.getName() + " because you are not enrolled");
        }
    }


    public static void checkGrade(Student student, Course course) {
        boolean hasEnrolled = StudentChecking.checkEnrollmentStatus(student, course);
        boolean hasBeenGraded = StudentChecking.checkIfGraded(student, course);
        if (hasEnrolled) {
            if (hasBeenGraded) {
                System.out.println("Your grade for " + course.getName() + " is " + getGrade(student, course));
            } else {
                System.out.println("You do not have a grade for " + course.getName() + "yet");
            }
        } else {
            System.out.println("You did not enroll in " + course.getName() + ", so you do not have a grade");
        }
    }
}
