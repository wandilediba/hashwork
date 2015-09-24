/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.EmployeeAllowance;
import hashwork.repository.payroll.core.EmployeeAllowanceRepository;
import hashwork.repository.payroll.core.Impl.EmployeeAllowanceRepositoryImpl;
import hashwork.services.payroll.core.EmployeeAllowanceService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeAllowanceServiceImpl implements EmployeeAllowanceService{
 private final EmployeeAllowanceRepository repo = new EmployeeAllowanceRepositoryImpl();
 
    @Override
    public EmployeeAllowance findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeAllowance save(EmployeeAllowance entity) {
         return repo.save(entity);
    }

    @Override
    public EmployeeAllowance update(EmployeeAllowance entity) {
         return repo.save(entity);
    }

    @Override
    public void delete(EmployeeAllowance entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeeAllowance> findAll() {
         return repo.findAll();
    }
    
}
