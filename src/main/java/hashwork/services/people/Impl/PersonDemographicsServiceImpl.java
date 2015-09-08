/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonDemographics;
import hashwork.repository.people.Impl.PersonDemographicsRepositoryImpl;
import hashwork.repository.people.PersonDemographicsRepository;
import hashwork.services.people.PersonDemographicsService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonDemographicsServiceImpl implements PersonDemographicsService {
    private final PersonDemographicsRepository repo = new PersonDemographicsRepositoryImpl();

    @Override
    public PersonDemographics findById(String s) {
        return repo.findById(s);
    }

    @Override
    public PersonDemographics save(PersonDemographics entity) {
        return repo.save(entity);
    }

    @Override
    public PersonDemographics update(PersonDemographics entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PersonDemographics entity) {
        repo.delete(entity);
    }

    @Override
    public Set<PersonDemographics> findAll() {
        return repo.findAll();
    }

}
