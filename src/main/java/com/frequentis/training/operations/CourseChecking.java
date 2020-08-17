package com.frequentis.training.operations;

import com.frequentis.training.course.Course;
import com.frequentis.training.repository.SchoolRepository;

public class CourseChecking {
    public static boolean checkIfTaughtBySomeone(Course course) {
        return SchoolRepository.getCourseTeacherMap().containsKey(course);
    }

    public static boolean checkIfItHasGrades(Course course) {
        return SchoolRepository.getGrades().get(course).size() > 0;
    }
}
