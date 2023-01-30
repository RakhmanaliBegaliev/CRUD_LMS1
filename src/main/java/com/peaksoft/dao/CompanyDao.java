package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;

import java.util.List;

public interface CompanyDao {
    List<Company>getAllCompanies();
    void addCompany(Company company);
    void updateCompany(Long id, Company company);
    Company getById(Long id);
    void deleteCompany(Company company);
    List<Course>getCourseByCompanyId(Long id);
}
