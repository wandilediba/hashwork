/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.Person;
import hashwork.repository.people.PersonRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonRepositoryImpl implements PersonRepository{
   Map<String, Person> lists = new HashMap<>();

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
