/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.CompanyPayroll;
import hashwork.repository.payroll.core.CompanyPayrollRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class CompanyPayrollRepositoryImpl implements CompanyPayrollRepository{
    Redisson redisson = Connection.getConnection();
    RMap<String, CompanyPayroll> lists = redisson.getMap("compPayroll");
 
   public CompanyPayrollRepositoryImpl() {

    }
 
    @Override
    public CompanyPayroll findById(String s) {
        return lists.get(s);
    }

    @Override
    public CompanyPayroll save(CompanyPayroll entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public CompanyPayroll update(CompanyPayroll entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CompanyPayroll entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<CompanyPayroll> findAll() {
        Set<CompanyPayroll> set = new HashSet<>();
        for (Map.Entry<String, CompanyPayroll> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
