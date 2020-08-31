package com.frequentis.training.repository;

import com.frequentis.training.course.Course;
import com.frequentis.training.course.Grade;
import com.frequentis.training.people.Student;
import com.frequentis.training.people.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolRepository {
    private static List<Course> courses;
    private static Map<Course, List<Student>> enrollments;
    private static Map<Course, Map<Integer, List<Student>>> attendances;
    private static Map<Course, List<Grade>> grades;
    private static Map<Course, Teacher> courseTeacherMap;

    static {
        courses = new ArrayList<>();
        enrollments = new HashMap<>();
        attendances = new HashMap<>();
        grades = new HashMap<>();
        courseTeacherMap = new HashMap<>();
    }
    public static List<Course> getCourses() {
        return courses;
    }

    public static Map<Course, List<Student>> getEnrollments() {
        return enrollments;
    }

    public static Map<Course, Map<Integer, List<Student>>> getAttendances() {
        return attendances;
    }

    public static Map<Course, List<Grade>> getGrades() {
        return grades;
    }

    public static Map<Course, Teacher> getCourseTeacherMap() {
        return courseTeacherMap;
    }
}
