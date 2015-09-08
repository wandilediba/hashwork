/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.CompanyPayroll;
import hashwork.domain.payroll.core.deductions.EmployeeUIFContribution;
import hashwork.repository.payroll.core.deductions.EmployeeUIFContributionRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeUIFContributionRepositoryImpl implements EmployeeUIFContributionRepository{

    Map<String, EmployeeUIFContribution> lists = new HashMap<>();
 
   public EmployeeUIFContributionRepositoryImpl() {

    }
    @Override
    public EmployeeUIFContribution findById(String s) {
       return lists.get(s);
    }

    @Override
    public EmployeeUIFContribution save(EmployeeUIFContribution entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeUIFContribution update(EmployeeUIFContribution entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeUIFContribution entity) {
         lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeUIFContribution> findAll() {
       Set<EmployeeUIFContribution> set = new HashSet<>();
        for (Map.Entry<String, EmployeeUIFContribution> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
