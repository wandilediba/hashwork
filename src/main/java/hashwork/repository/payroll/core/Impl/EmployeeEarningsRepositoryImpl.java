/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.EmployeeEarnings;
import hashwork.repository.payroll.core.EmployeeEarningsRepository;
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
public class EmployeeEarningsRepositoryImpl implements EmployeeEarningsRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeeEarnings> lists = redisson.getMap("empEarnings");

    public EmployeeEarningsRepositoryImpl() {

    }
@Override
    public EmployeeEarnings findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeeEarnings save(EmployeeEarnings entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeEarnings update(EmployeeEarnings entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeEarnings entity) {
         lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeEarnings> findAll() {
         Set<EmployeeEarnings> set = new HashSet<>();
        for (Map.Entry<String, EmployeeEarnings> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
