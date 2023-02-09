package com.peaksoft.dao.impl;

import com.peaksoft.dao.TeacherDao;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("from Teacher").getResultList();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class, id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setLastName(teacher.getLastName());
        entityManager.merge(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ? teacher : entityManager.merge(teacher));
        //entityManager.remove(teacher);
    }

    @Override
    public Course getByTeacherId(Long id) {
        return (Course) entityManager.createQuery("select c from Course c join c.teacher t where t.id=?1").setParameter(1,id)
                .getSingleResult();
    }

    @Override
    public List<Student> sizeOfStudents(Long id) {
        List<Student>students = entityManager.createQuery("select s from Student s join" +
                " s.group g join g.courses c join c.teacher t where t.id=?1").setParameter(1, id).getResultList();
        return students;
    }

}
//    List<Student>students = entityManager.createQuery("select s from Student s join" +
//            " s.group g join g.courses c join c.teacher t where t.id=?1").setParameter(1,id).getResultList();