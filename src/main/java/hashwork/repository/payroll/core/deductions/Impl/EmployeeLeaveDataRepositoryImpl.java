/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.deductions.EmployeeLeaveData;
import hashwork.repository.payroll.core.deductions.EmployeeLeaveDataRepository;
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
public class EmployeeLeaveDataRepositoryImpl implements EmployeeLeaveDataRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeeLeaveData> lists = redisson.getMap("empLeaveData");
 
  public EmployeeLeaveDataRepositoryImpl() {

    }
    @Override
    public EmployeeLeaveData findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeeLeaveData save(EmployeeLeaveData entity) {
      return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeLeaveData update(EmployeeLeaveData entity) {
         return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeLeaveData entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeLeaveData> findAll() {
        Set<EmployeeLeaveData> set = new HashSet<>();
        for (Map.Entry<String, EmployeeLeaveData> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
