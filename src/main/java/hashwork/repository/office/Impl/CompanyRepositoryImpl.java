/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.office.Impl;


import hashwork.app.conf.Connection;
import hashwork.domain.office.Company;
import hashwork.repository.office.CompanyRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author BONGANI
 */
public class CompanyRepositoryImpl implements CompanyRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Company> lists = redisson.getMap("Company");

    @Override
    public Company findById(String s) {
        return lists.get(s);
    }

    @Override
    public Company save(Company entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Company update(Company entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Company entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Company> findAll() {
        Set<Company> set = new HashSet<>();
        for (Map.Entry<String, Company> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
