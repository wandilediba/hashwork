/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeePension;
import hashwork.repository.payroll.core.deductions.EmployeePensionRepository;
import hashwork.repository.payroll.core.deductions.Impl.EmployeePensionRepositoryImpl;
import hashwork.services.payroll.core.deductions.EmployeePensionService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeePensionServiceImpl implements EmployeePensionService{
 private final EmployeePensionRepository repo = new EmployeePensionRepositoryImpl();
    @Override
    public EmployeePension findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeePension save(EmployeePension entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeePension update(EmployeePension entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeePension entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeePension> findAll() {
        return repo.findAll();
    }
    
}
