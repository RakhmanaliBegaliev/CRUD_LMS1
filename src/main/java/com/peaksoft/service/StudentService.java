package com.peaksoft.service;

import java.util.List;

public interface StudentService {
    List<com.peaksoft.entity.Student> getAllStudents();
    void addStudent(com.peaksoft.entity.Student student);
    void updateStudent(Long id, com.peaksoft.entity.Student student);
    com.peaksoft.entity.Student getById(Long id);
    void deleteStudent(com.peaksoft.entity.Student student);
}
