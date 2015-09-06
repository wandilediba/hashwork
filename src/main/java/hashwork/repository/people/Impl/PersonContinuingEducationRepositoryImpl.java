/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonContinuingEducation;
import hashwork.repository.people.PersonContinuingEducationRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonContinuingEducationRepositoryImpl implements PersonContinuingEducationRepository {
    Map<String, PersonContinuingEducation> lists = new HashMap<>();

    public PersonContinuingEducationRepositoryImpl() {

    }

    @Override
    public PersonContinuingEducation findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonContinuingEducation save(PersonContinuingEducation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonContinuingEducation update(PersonContinuingEducation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonContinuingEducation entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonContinuingEducation> findAll() {
        Set<PersonContinuingEducation> set = new HashSet<>();
        for (Map.Entry<String, PersonContinuingEducation> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;

    }


}
