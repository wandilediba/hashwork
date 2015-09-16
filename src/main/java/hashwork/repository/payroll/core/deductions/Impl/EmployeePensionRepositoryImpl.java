/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.deductions.EmployeePension;
import hashwork.repository.payroll.core.deductions.EmployeePensionRepository;
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
public class EmployeePensionRepositoryImpl implements EmployeePensionRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeePension> lists = redisson.getMap("employeePension");

 public EmployeePensionRepositoryImpl() {

    }
    @Override
    public EmployeePension findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeePension save(EmployeePension entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeePension update(EmployeePension entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeePension entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeePension> findAll() {
       Set<EmployeePension> set = new HashSet<>();
        for (Map.Entry<String, EmployeePension> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
