/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonBenefitsFundingSource;
import hashwork.repository.people.Impl.PersonBenifitsFundingSourceRepositoryImpl;
import hashwork.repository.people.PersonBenifitsFundingSourceRepository;
import hashwork.services.people.PersonBenefitsFundingSourceService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonBenefitsFundingSourceImpl implements PersonBenefitsFundingSourceService {
    private final PersonBenifitsFundingSourceRepository repo = new PersonBenifitsFundingSourceRepositoryImpl();

    @Override
    public PersonBenefitsFundingSource findById(String s) {
        return repo.findById(s);
    }

    @Override
    public PersonBenefitsFundingSource save(PersonBenefitsFundingSource entity) {
        return repo.save(entity);
    }

    @Override
    public PersonBenefitsFundingSource update(PersonBenefitsFundingSource entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PersonBenefitsFundingSource entity) {
        repo.delete(entity);
    }

    @Override
    public Set<PersonBenefitsFundingSource> findAll() {
        return repo.findAll();
    }

}
