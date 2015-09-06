/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.office.Impl;

import hashwork.domain.office.Company;
import hashwork.repository.office.CompanyRepository;
import hashwork.repository.office.Impl.CompanyRepositoryImpl;
import hashwork.services.office.CompanyService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */

public class CompanyServiceImpl implements CompanyService {
      private final CompanyRepository repo = new CompanyRepositoryImpl();
    @Override
    public Company findById(String id) {
       return repo.findById(id);
    }

    @Override
    public Company save(Company entity) {
        return repo.save(entity);
    }

    @Override
    public Company update(Company entity) {
         return repo.save(entity);
    }

    @Override
    public void delete(Company entity) {
          repo.delete(entity);
    }

    @Override
    public Set<Company> findAll() {
        return repo.findAll();
    }
    
    
}
