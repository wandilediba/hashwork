/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonBenefits;
import hashwork.repository.people.PersonBenifitsRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonBenifitsRepositoryImpl implements PersonBenifitsRepository{
    Map<String, PersonBenefits> lists = new HashMap<>();

   public PersonBenifitsRepositoryImpl() {

    }

    @Override
    public PersonBenefits findById(String s) {
    return lists.get(s);
    }

    @Override
    public PersonBenefits save(PersonBenefits entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonBenefits update(PersonBenefits entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonBenefits entity) {
      lists.remove(entity.getId());
    }

    @Override
    public Set<PersonBenefits> findAll() {
    Set<PersonBenefits> set = new HashSet<>();
        for (Map.Entry<String, PersonBenefits> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
   
    
}
