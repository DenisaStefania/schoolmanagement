package com.frequentis.training.operations;

import com.frequentis.training.course.Course;
import com.frequentis.training.course.Grade;
import com.frequentis.training.people.Student;
import com.frequentis.training.repository.SchoolRepository;
import com.frequentis.training.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentChecking {
    public static boolean checkEnrollmentStatus(Student student, Course course) {
        Map<Course, List<Student>> enrollments = SchoolRepository.getEnrollments();
        if (enrollments.containsKey(course)) { //the course the student wants to enroll in is already present in the enrollments map
            if (enrollments.get(course).contains(student)) {
                return true;
            }
            return false; //student is not enrolled
        } else {
            SchoolRepository.getEnrollments().put(course, new ArrayList<>()); //add the course to the map of enrollments
            return false; //the student is not enrolled
        }
    }

    public static boolean checkAttendance(Student student, Course course, int courseSession) {
        Map<Course, Map<Integer, List<Student>>> allAttendances = SchoolRepository.getAttendances();
        if (allAttendances.containsKey(course)) { // check if the course the student wants to attend is in the allAttendances map
            if (allAttendances.get(course).get(courseSession).contains(student)) {
                return true;
            }
            return false; // the student did not attend the specific session for the course
        } else {
            List<Student> students = new ArrayList<>();
            students.add(student);
            Map<Integer, List<Student>> attendance = new HashMap<>();
            attendance.put(courseSession, students);
            SchoolRepository.getAttendances().put(course, attendance);
            return false; //the student did not attend the specific session for the course
        }
    }

    public static Response checkIfGraded(Student student, Course course) {
        String studentName = student.getName();
        List<Grade> grades = SchoolRepository.getGrades().get(course);
        for (Grade grade : grades) {
            if (grade.getStudentName().equals(studentName)) {
               return new Response(true, grade.getGradePoints());
            }
        }
        return new Response(false, 0);
    }
}
