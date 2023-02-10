package com.peaksoft.service;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void addGroup(Group group, Long courseId);

    void updateGroup(Long id, Group group);

    Group getById(Long id);

    void deleteGroup(Group group);
    List<Course> getCourseByGroupId(Long id);

    List<Student> getStudentsByGroupId(Long id);
    List<Student>search(String name, Long groupId);
}
