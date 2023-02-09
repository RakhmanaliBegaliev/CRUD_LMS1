package com.peaksoft.service;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void addCompany(Company company);

    void updateCompany(Long id, Company company);

    Company getById(Long id);

    void deleteCompany(Company company);

    List<Course> getCourseByCompanyId(Long id);
//    List<Student> getStudentsByCompanyId(Long id);
    List<Student> size(Long id);

}
