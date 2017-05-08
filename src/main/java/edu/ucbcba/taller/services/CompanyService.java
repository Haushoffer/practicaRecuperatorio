package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Company;

/**
 * Created by coreI7 on 30/04/2017.
 */
public interface CompanyService {
    Iterable<Company> listAllCompanies();

    Company getCompanyById(Integer id);

    Company saveCompany(Company company);

    void deleteCompany(Integer id);
}
