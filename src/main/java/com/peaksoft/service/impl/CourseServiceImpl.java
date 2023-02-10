package com.peaksoft.service.impl;

import com.peaksoft.dao.CompanyDao;
import com.peaksoft.dao.CourseDao;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;
    private final CompanyDao companyDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao, CompanyDao companyDao) {
        this.courseDao = courseDao;
        this.companyDao = companyDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void addCourse(Course course, Long companyId) {
        Company company = companyDao.getById(companyId);
        course.setCompany(company);
        courseDao.addCourse(course);
    }

    public void updateCourse(Long id, Course course, Long companyId) {
        Company company = companyDao.getById(companyId);
        course.setCompany(company);
        courseDao.updateCourse(id, course);
    }

    @Override
    public Course getById(Long id) {
        return courseDao.getById(id);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }

    @Override
    public List<Group> getGroupByCourseId(Long id) {
        return courseDao.getGroupByCourseId(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return courseDao.getTeacherById(id);
    }


}
