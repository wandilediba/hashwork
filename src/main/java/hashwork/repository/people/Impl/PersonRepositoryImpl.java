/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.Person;
import hashwork.domain.people.PersonAddress;
import hashwork.repository.people.PersonRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonRepositoryImpl implements PersonRepository {
     Redisson redisson = Connection.getConnection();
    RMap<String, Person> lists = redisson.getMap("addresstype");
    
  
    public PersonRepositoryImpl() {

    }

    @Override
    public Person findById(String s) {
        return lists.get(s);
    }

    @Override
    public Person save(Person entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Person update(Person entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Person entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Person> findAll() {
        Set<Person> set = new HashSet<>();
        for (Map.Entry<String, Person> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
