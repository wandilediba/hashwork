/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.CompanyPayroll;
import hashwork.repository.payroll.core.CompanyPayrollRepository;
import hashwork.repository.payroll.core.Impl.CompanyPayrollRepositoryImpl;
import hashwork.services.payroll.core.CompanyPayrollService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class CompanyPayrollServiceImpl implements CompanyPayrollService{
 private final CompanyPayrollRepository repo = new CompanyPayrollRepositoryImpl();
 
    @Override
    public CompanyPayroll findById(String s) {
        return repo.findById(s);
    }

    @Override
    public CompanyPayroll save(CompanyPayroll entity) {
        return repo.save(entity);
    }

    @Override
    public CompanyPayroll update(CompanyPayroll entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(CompanyPayroll entity) {
       repo.delete(entity);
    }

    @Override
    public Set<CompanyPayroll> findAll() {
       return repo.findAll();
    }
    
}
