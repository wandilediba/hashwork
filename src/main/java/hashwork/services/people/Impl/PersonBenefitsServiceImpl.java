/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonBenefits;
import hashwork.repository.people.Impl.PersonBenefitsRepositoryImpl;
import hashwork.repository.people.PersonBenefitsRepository;
import hashwork.services.people.PersonBenefitsService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonBenefitsServiceImpl implements PersonBenefitsService {
   // private final PersonBenefitsRepository repo = new PersonBenefitsRepositoryImpl();

    @Override
    public PersonBenefits findById(String s) {
       return new PersonBenefitsRepositoryImpl().findById(s);
    }

    @Override
    public PersonBenefits save(PersonBenefits entity) {
         return new PersonBenefitsRepositoryImpl().save(entity);
    }

    @Override
    public PersonBenefits update(PersonBenefits entity) {
          return new PersonBenefitsRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonBenefits entity) {
        new PersonBenefitsRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonBenefits> findAll() {
        return new PersonBenefitsRepositoryImpl().findAll();
    }

}
