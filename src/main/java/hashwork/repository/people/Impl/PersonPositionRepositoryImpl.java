/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonPosition;
import hashwork.repository.people.PersonPositionRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonPositionRepositoryImpl implements PersonPositionRepository{
  Map<String, PersonPosition> lists = new HashMap<>();

   public PersonPositionRepositoryImpl() {

    }
    @Override
    public PersonPosition findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonPosition save(PersonPosition entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonPosition update(PersonPosition entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonPosition entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<PersonPosition> findAll() {
     Set<PersonPosition> set = new HashSet<>();
        for (Map.Entry<String, PersonPosition> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
