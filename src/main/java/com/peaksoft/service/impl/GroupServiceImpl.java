package com.peaksoft.service.impl;

import com.peaksoft.dao.CourseDao;
import com.peaksoft.dao.GroupDao;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;
    private final CourseDao courseDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao, CourseDao courseDao) {
        this.groupDao = groupDao;
        this.courseDao = courseDao;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void addGroup(Group group, Long courseId) {
        Course course = courseDao.getById(courseId);
        group.setCourseId(courseId);
        groupDao.addGroup(group);
    }

    @Override
    public void updateGroup(Long id, Group group) {
        groupDao.updateGroup(id, group);
    }

    @Override
    public Group getById(Long id) {
        return groupDao.getById(id);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }

    @Override
    public List<Course> getCourseByGroupId(Long id) {
        return groupDao.getCourseByGroupId(id);
    }

    @Override
    public List<Student> getStudentsByGroupId(Long id) {
        return groupDao.getStudentByGroupId(id);
    }

    @Override
    public List<Student> search(String name, Long groupId) {
        return  groupDao.search(name, groupId);
    }



}
