package com.peaksoft.dao.impl;

import com.peaksoft.dao.TeacherDao;
import com.peaksoft.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("from Teacher ").getResultList();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class, id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        entityManager.merge(teacher1);
    }

    @Override
    public Teacher getById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(teacher);
    }
}
