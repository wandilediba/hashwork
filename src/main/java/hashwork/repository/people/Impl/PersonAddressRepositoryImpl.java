/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.repository.people.PersonAddressRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonAddressRepositoryImpl implements PersonAddressRepository {
     Redisson redisson = Connection.getConnection();
    RMap<String, PersonAddress> lists = redisson.getMap("PersonAddress");

    public PersonAddressRepositoryImpl() {

    }

    @Override
    public PersonAddress findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonAddress save(PersonAddress entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonAddress update(PersonAddress entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonAddress entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonAddress> findAll() {

        Set<PersonAddress> set = new HashSet<>();
        for (Map.Entry<String, PersonAddress> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;

    }


}
