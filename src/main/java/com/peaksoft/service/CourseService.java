package com.peaksoft.service;

import com.peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    void addCourse(Course course);
    void updateCourse(Long id, Course course);
    Course getById(Long id);
    void deleteCourse(Course course);
}
