/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.office.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.office.Department;
import hashwork.repository.office.DepartmentRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BONGANI
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Department> lists = redisson.getMap("Department");

    @Override
    public Department findById(String s) {
        return lists.get(s);
    }

    @Override
    public Department save(Department entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Department update(Department entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Department entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Department> findAll() {
        Set<Department> set = new HashSet<>();
        for (Map.Entry<String, Department> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
