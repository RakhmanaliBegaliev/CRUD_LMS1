package com.peaksoft.dao;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();

    void addGroup(Group group);

    void updateGroup(Long id, Group group);

    Group getById(Long id);

    void deleteGroup(Group group);
}
