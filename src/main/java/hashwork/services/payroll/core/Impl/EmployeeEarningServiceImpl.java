/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.EmployeeEarnings;
import hashwork.repository.payroll.core.EmployeeEarningsRepository;
import hashwork.repository.payroll.core.Impl.EmployeeEarningsRepositoryImpl;
import hashwork.services.payroll.core.EmployeeEarningService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeEarningServiceImpl implements EmployeeEarningService{
private final EmployeeEarningsRepository repo = new EmployeeEarningsRepositoryImpl();
    @Override
    public EmployeeEarnings findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeEarnings save(EmployeeEarnings entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeeEarnings update(EmployeeEarnings entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeeEarnings entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeeEarnings> findAll() {
        return repo.findAll();
    }
    
}
