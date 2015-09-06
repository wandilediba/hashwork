/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonBenefitsFundingSource;
import hashwork.repository.people.PersonBenifitsFundingSourceRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonBenifitsFundingSourceRepositoryImpl implements PersonBenifitsFundingSourceRepository {
    Map<String, PersonBenefitsFundingSource> lists = new HashMap<>();

    public PersonBenifitsFundingSourceRepositoryImpl() {

    }

    @Override
    public PersonBenefitsFundingSource findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonBenefitsFundingSource save(PersonBenefitsFundingSource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonBenefitsFundingSource update(PersonBenefitsFundingSource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonBenefitsFundingSource entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonBenefitsFundingSource> findAll() {
        Set<PersonBenefitsFundingSource> set = new HashSet<>();
        for (Map.Entry<String, PersonBenefitsFundingSource> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
