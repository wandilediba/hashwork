/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonHiringDecision;
import hashwork.repository.people.Impl.PersonHiringDecisionRepositoryImpl;
import hashwork.repository.people.PersonHiringDecisionRepository;
import hashwork.services.people.PersonHiringDecisionService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonHiringDecisionServiceImpl implements PersonHiringDecisionService {
   // private final PersonHiringDecisionRepository repo = new PersonHiringDecisionRepositoryImpl();

    @Override
    public PersonHiringDecision findById(String s) {
        return new PersonHiringDecisionRepositoryImpl().findById(s);
    }

    @Override
    public PersonHiringDecision save(PersonHiringDecision entity) {
        return new PersonHiringDecisionRepositoryImpl().save(entity);
    }

    @Override
    public PersonHiringDecision update(PersonHiringDecision entity) {
        return new PersonHiringDecisionRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonHiringDecision entity) {
         new PersonHiringDecisionRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonHiringDecision> findAll() {
       return new PersonHiringDecisionRepositoryImpl().findAll();
    }

}
