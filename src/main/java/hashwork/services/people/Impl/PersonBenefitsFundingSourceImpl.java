/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonBenefitsFundingSource;
import hashwork.repository.people.Impl.PersonBenefitsFundingSourceRepositoryImpl;
import hashwork.repository.people.PersonBenefitsFundingSourceRepository;
import hashwork.services.people.PersonBenefitsFundingSourceService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonBenefitsFundingSourceImpl implements PersonBenefitsFundingSourceService {
    //private final PersonBenefitsFundingSourceRepository repo = new PersonBenefitsFundingSourceRepositoryImpl();

    @Override
    public PersonBenefitsFundingSource findById(String s) {
       return new PersonBenefitsFundingSourceRepositoryImpl().findById(s);
    }

    @Override
    public PersonBenefitsFundingSource save(PersonBenefitsFundingSource entity) {
         return new PersonBenefitsFundingSourceRepositoryImpl().save(entity);
    }

    @Override
    public PersonBenefitsFundingSource update(PersonBenefitsFundingSource entity) {
        return new PersonBenefitsFundingSourceRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonBenefitsFundingSource entity) {
        new PersonBenefitsFundingSourceRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonBenefitsFundingSource> findAll() {
         return new PersonBenefitsFundingSourceRepositoryImpl().findAll();
    }

}
