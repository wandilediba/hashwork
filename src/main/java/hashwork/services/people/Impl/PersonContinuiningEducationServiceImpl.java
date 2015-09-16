/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonContinuingEducation;
import hashwork.repository.people.Impl.PersonContinuingEducationRepositoryImpl;
import hashwork.repository.people.PersonContinuingEducationRepository;
import hashwork.services.people.PersonContinuinigEducationService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonContinuiningEducationServiceImpl implements PersonContinuinigEducationService {
    //private final PersonContinuingEducationRepository repo = new PersonContinuingEducationRepositoryImpl();

    @Override
    public PersonContinuingEducation findById(String s) {
        return new PersonContinuingEducationRepositoryImpl().findById(s);
    }

    @Override
    public PersonContinuingEducation save(PersonContinuingEducation entity) {
        return new PersonContinuingEducationRepositoryImpl().save(entity);
    }

    @Override
    public PersonContinuingEducation update(PersonContinuingEducation entity) {
       return new PersonContinuingEducationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonContinuingEducation entity) {
        new PersonContinuingEducationRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonContinuingEducation> findAll() {
       return new PersonContinuingEducationRepositoryImpl().findAll();
    }

}
