package com.peaksoft.dao.impl;

import com.peaksoft.dao.CourseDao;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager entityManager;
    private CompanyService companyService;
    private GroupService groupService;

    @Autowired
    public CourseDaoImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course").getResultList();
    }

    @Override
    public void addCourse(Course course) {
        Company company = companyService.getById(course.getCompanyId());
        course.setCompany(company);
        entityManager.persist(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        entityManager.merge(course);
    }

    @Override
    public Course getById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));
    }

    @Override
    public List<Group> getGroupByCourseId(Long id) {
        List<Group> groups = entityManager.createQuery("select g from Group g join  g.courses c where c.id= ?1")
                .setParameter(1, id).getResultList();
        return groups;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }


}
