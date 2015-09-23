/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonBenefits;
import hashwork.repository.people.Impl.PersonBenifitsRepositoryImpl;
import hashwork.repository.people.PersonBenifitsRepository;
import hashwork.services.people.PersonBenefitsService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonBenefitsServiceImpl implements PersonBenefitsService {
   // private final PersonBenifitsRepository repo = new PersonBenifitsRepositoryImpl();

    @Override
    public PersonBenefits findById(String s) {
       return new PersonBenifitsRepositoryImpl().findById(s);
    }

    @Override
    public PersonBenefits save(PersonBenefits entity) {
         return new PersonBenifitsRepositoryImpl().save(entity);
    }

    @Override
    public PersonBenefits update(PersonBenefits entity) {
          return new PersonBenifitsRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonBenefits entity) {
        new PersonBenifitsRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonBenefits> findAll() {
        return new PersonBenifitsRepositoryImpl().findAll();
    }

}
