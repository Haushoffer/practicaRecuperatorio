package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Company;
import edu.ucbcba.taller.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by JOEL on 30/04/2017.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier(value = "companyRepository")
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Iterable<Company> listAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.delete(id);
    }
}
