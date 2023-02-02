package com.peaksoft.service;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void addCompany(Company company);

    void updateCompany(Long id, Company company);

    Company getById(Long id);

    void deleteCompany(Company company);

    List<Course> getCourseByCompanyId(Long id);

}
