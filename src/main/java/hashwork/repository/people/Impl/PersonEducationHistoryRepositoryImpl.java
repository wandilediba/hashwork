/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.domain.people.PersonEducationHistory;
import hashwork.repository.people.PersonEducationHistoryRepository;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonEducationHistoryRepositoryImpl implements PersonEducationHistoryRepository {
     Redisson redisson = Connection.getConnection();
    RMap<String, PersonEducationHistory> lists = redisson.getMap("addresstype");
    
   public PersonEducationHistoryRepositoryImpl() {

    }

    @Override
    public PersonEducationHistory findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonEducationHistory save(PersonEducationHistory entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonEducationHistory update(PersonEducationHistory entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonEducationHistory entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonEducationHistory> findAll() {
        Set<PersonEducationHistory> set = new HashSet<>();
        for (Map.Entry<String, PersonEducationHistory> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
