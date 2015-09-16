/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeeDeductions;
import hashwork.repository.payroll.core.deductions.EmployeeDeductionsRepository;
import hashwork.repository.payroll.core.deductions.Impl.EmployeeDeductionsRepositoryImpl;
import hashwork.services.payroll.core.deductions.EmployeeDeductionsService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeDeductionsServicesImpl implements EmployeeDeductionsService{
 private final EmployeeDeductionsRepository repo = new EmployeeDeductionsRepositoryImpl();
 
    @Override
    public EmployeeDeductions findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeDeductions save(EmployeeDeductions entity) {
       return repo.save(entity);
    }

    @Override
    public EmployeeDeductions update(EmployeeDeductions entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeeDeductions entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeeDeductions> findAll() {
         return repo.findAll();
    }
    
}
