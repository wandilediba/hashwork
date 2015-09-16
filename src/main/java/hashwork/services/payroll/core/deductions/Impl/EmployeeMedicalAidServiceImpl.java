/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeeMedicalAid;
import hashwork.repository.payroll.core.deductions.EmployeeMedicalAidRepository;
import hashwork.repository.payroll.core.deductions.Impl.EmployeeMedicalAidRepositoryImpl;
import hashwork.services.payroll.core.deductions.EmployeeMedicalAidService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeMedicalAidServiceImpl implements EmployeeMedicalAidService{
 private final EmployeeMedicalAidRepository repo = new EmployeeMedicalAidRepositoryImpl();
    @Override
    public EmployeeMedicalAid findById(String s) {
       return repo.findById(s);
    }

    @Override
    public EmployeeMedicalAid save(EmployeeMedicalAid entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeeMedicalAid update(EmployeeMedicalAid entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeeMedicalAid entity) {
       repo.delete(entity);
    }

    @Override
    public Set<EmployeeMedicalAid> findAll() {
       return repo.findAll();
    }
    
}
