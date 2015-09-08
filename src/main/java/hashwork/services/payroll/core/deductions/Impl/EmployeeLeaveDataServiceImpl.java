/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeeLeaveData;
import hashwork.repository.payroll.core.deductions.EmployeeLeaveDataRepository;
import hashwork.repository.payroll.core.deductions.Impl.EmployeeLeaveDataRepositoryImpl;
import hashwork.services.payroll.core.deductions.EmployeeLeaveDataService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeLeaveDataServiceImpl implements EmployeeLeaveDataService{
 private final EmployeeLeaveDataRepository repo = new EmployeeLeaveDataRepositoryImpl();
    @Override
    public EmployeeLeaveData findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeLeaveData save(EmployeeLeaveData entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeeLeaveData update(EmployeeLeaveData entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeeLeaveData entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeeLeaveData> findAll() {
        return repo.findAll();
    }
    
}
