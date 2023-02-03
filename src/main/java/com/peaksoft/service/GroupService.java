package com.peaksoft.service;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void addGroup(Group group);

    void updateGroup(Long id, Group group);

    Group getById(Long id);

    void deleteGroup(Group group);
}
