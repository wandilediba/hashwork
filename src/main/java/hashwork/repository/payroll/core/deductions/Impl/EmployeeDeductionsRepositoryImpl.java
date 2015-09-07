/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.CompanyPayroll;
import hashwork.domain.payroll.core.deductions.EmployeeDeductions;
import hashwork.repository.payroll.core.deductions.EmployeeDeductionsRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeDeductionsRepositoryImpl  implements  EmployeeDeductionsRepository{
 Map<String, EmployeeDeductions> lists = new HashMap<>();
 public EmployeeDeductionsRepositoryImpl() {

    }
 
    @Override
    public EmployeeDeductions findById(String s) {
       return lists.get(s);
    }

    @Override
    public EmployeeDeductions save(EmployeeDeductions entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeDeductions update(EmployeeDeductions entity) {
         return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeDeductions entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeDeductions> findAll() {
        Set<EmployeeDeductions> set = new HashSet<>();
        for (Map.Entry<String, EmployeeDeductions> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
