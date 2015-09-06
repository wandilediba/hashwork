/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonContact;
import hashwork.repository.people.Impl.PersonContactRepositoryImpl;
import hashwork.repository.people.PersonContactRepository;
import hashwork.services.people.PersonContactService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonContactServiceImpl implements PersonContactService {
    private final PersonContactRepository repo = new PersonContactRepositoryImpl();

    @Override
    public PersonContact findById(String s) {
        return repo.findById(s);
    }

    @Override
    public PersonContact save(PersonContact entity) {
        return repo.save(entity);
    }

    @Override
    public PersonContact update(PersonContact entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PersonContact entity) {
        repo.delete(entity);
    }

    @Override
    public Set<PersonContact> findAll() {
        return repo.findAll();
    }

}
