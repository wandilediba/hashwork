/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonEmploymentHistory;
import hashwork.repository.people.PersonEmploymentHistoryRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonEmploymentHistoryRepositoryImpl implements PersonEmploymentHistoryRepository{
    Map<String, PersonEmploymentHistory> lists = new HashMap<>();

   public PersonEmploymentHistoryRepositoryImpl() {

    }
    @Override
    public PersonEmploymentHistory findById(String s) {
         return lists.get(s);
    }

    @Override
    public PersonEmploymentHistory save(PersonEmploymentHistory entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonEmploymentHistory update(PersonEmploymentHistory entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonEmploymentHistory entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<PersonEmploymentHistory> findAll() {
       Set<PersonEmploymentHistory> set = new HashSet<>();
        for (Map.Entry<String, PersonEmploymentHistory> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
