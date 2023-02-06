package com.peaksoft.dao.impl;

import com.peaksoft.dao.GroupDao;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager entityManager;
    private CourseService courseService;

    @Autowired
    public GroupDaoImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Group> getAllGroups() {
        return entityManager.createQuery("from Group").getResultList();
    }

    @Override
    public void addGroup(Group group) {
        Course course = courseService.getById(group.getCourseId());
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        entityManager.persist(group);

    }

    @Override
    public void updateGroup(Long id, Group group) {
        Group group1 = entityManager.find(Group.class, id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        entityManager.merge(group);
    }

    @Override
    public Group getById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group) ? group : entityManager.merge(group));
    }

    @Override
    public List<Course> getCourseByGroupId(Long id) {
        List<Course> course = entityManager.createQuery("select g from Group g join g.courses course where course.id = ?1")
                .setParameter(1, id).getResultList();
        return course;
    }

    @Override
    public List<Student> getStudentByGroupId(Long id) {
        List<Student> students = entityManager.createQuery("select g from Group g join g.students student where student.id = ?1")
                .setParameter(1,id).getResultList();
        return students;
    }

}
