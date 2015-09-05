/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonRole;
import hashwork.repository.people.Impl.PersonRoleRepositoryImpl;
import hashwork.repository.people.PersonRoleRepository;
import hashwork.services.people.PersonRoleService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonRoleServiceImpl implements PersonRoleService{
      private final PersonRoleRepository repo = new PersonRoleRepositoryImpl();
    @Override
    public PersonRole findById(String s) {
        return repo.findById(s);
    }
    @Override
    public PersonRole save(PersonRole entity) {
       return repo.save(entity);
    }

    @Override
    public PersonRole update(PersonRole entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PersonRole entity) {
           repo.delete(entity);
    }

    @Override
    public Set<PersonRole> findAll() {
         return repo.findAll();
    }
    
}
