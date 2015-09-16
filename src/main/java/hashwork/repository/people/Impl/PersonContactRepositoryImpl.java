/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.domain.people.PersonContact;
import hashwork.repository.people.PersonContactRepository;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonContactRepositoryImpl implements PersonContactRepository {
    
    Redisson redisson = Connection.getConnection();
    RMap<String, PersonContact> lists = redisson.getMap("addresstype");
    
    public PersonContactRepositoryImpl() {

    }

    @Override
    public PersonContact findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonContact save(PersonContact entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonContact update(PersonContact entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonContact entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonContact> findAll() {
        Set<PersonContact> set = new HashSet<>();
        for (Map.Entry<String, PersonContact> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
