/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.office.Impl;


import hashwork.domain.office.Company;
import hashwork.repository.office.CompanyRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author BONGANI
 */
public class CompanyRepositoryImpl implements CompanyRepository {
    Map<String, Company> lists = new HashMap<>();

    public CompanyRepositoryImpl() {

    }

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
