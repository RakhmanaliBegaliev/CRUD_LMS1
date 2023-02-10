package com.peaksoft.service;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void addCourse(Course course, Long companyId);
    void updateCourse(Long id, Course course, Long companyId);
    Course getById(Long id);
    void deleteCourse(Course course);
    List<Group> getGroupByCourseId(Long id);
    Teacher getTeacherById(Long id);

}
