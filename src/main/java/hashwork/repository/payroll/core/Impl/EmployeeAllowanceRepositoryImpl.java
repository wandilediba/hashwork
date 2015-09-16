/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.EmployeeAllowance;
import hashwork.repository.payroll.core.EmployeeAllowanceRepository;
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
public class EmployeeAllowanceRepositoryImpl implements EmployeeAllowanceRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeeAllowance> lists = redisson.getMap("empAllowance");

    public EmployeeAllowanceRepositoryImpl() {

    }

    @Override
    public EmployeeAllowance findById(String s) {
       return lists.get(s);
    }

    @Override
    public EmployeeAllowance save(EmployeeAllowance entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeAllowance update(EmployeeAllowance entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeAllowance entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeAllowance> findAll() {
        Set<EmployeeAllowance> set = new HashSet<>();
        for (Map.Entry<String, EmployeeAllowance> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
