/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeeDeductions;
import hashwork.domain.payroll.core.deductions.EmployeeMedicalAid;
import hashwork.repository.payroll.core.deductions.EmployeeMedicalAidRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeMedicalAidRepositoryImpl implements EmployeeMedicalAidRepository{
 Map<String, EmployeeMedicalAid> lists = new HashMap<>();
 
 public EmployeeMedicalAidRepositoryImpl() {

    }
 
    @Override
    public EmployeeMedicalAid findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeeMedicalAid save(EmployeeMedicalAid entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeMedicalAid update(EmployeeMedicalAid entity) {
         return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeMedicalAid entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeMedicalAid> findAll() {
        Set<EmployeeMedicalAid> set = new HashSet<>();
        for (Map.Entry<String, EmployeeMedicalAid> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
