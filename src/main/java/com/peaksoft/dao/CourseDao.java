package com.peaksoft.dao;

import com.peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourse();
    void addCourse(Course course);
    void updateCourse(Long id, Course course);
    Course getById(Long id);
    void deleteCourse(Course course);
}
