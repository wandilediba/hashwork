/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonIdentity;
import hashwork.repository.people.Impl.PersonIdentityRepositoryImpl;
import hashwork.repository.people.PersonIdentityRepository;
import hashwork.services.people.PersonIdentityService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonIdentityServiceImpl implements PersonIdentityService{
    private final PersonIdentityRepository repo = new PersonIdentityRepositoryImpl();
    @Override
    public PersonIdentity findById(String s) {
       return repo.findById(s);
    }

    @Override
    public PersonIdentity save(PersonIdentity entity) {
       return repo.save(entity);
    }

    @Override
    public PersonIdentity update(PersonIdentity entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PersonIdentity entity) {
          repo.delete(entity);
    }

    @Override
    public Set<PersonIdentity> findAll() {
        return repo.findAll();
    }
    
}
