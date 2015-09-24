/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.domain.people.PersonRole;
import hashwork.repository.people.PersonRoleRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonRoleRepositoryImpl implements PersonRoleRepository {
   
     Redisson redisson = Connection.getConnection();
    RMap<String, PersonRole> lists = redisson.getMap("addresstype");
    
    public PersonRoleRepositoryImpl() {

    }

    @Override
    public PersonRole findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonRole save(PersonRole entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonRole update(PersonRole entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonRole entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonRole> findAll() {
        Set<PersonRole> set = new HashSet<>();
        for (Map.Entry<String, PersonRole> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
