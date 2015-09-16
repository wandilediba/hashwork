/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.Person;
import hashwork.domain.people.PersonAddress;
import hashwork.repository.people.Impl.PersonAddressRepositoryImpl;
import hashwork.repository.people.PersonAddressRepository;
import hashwork.services.people.PersonAddressService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonAddressServiceImpl implements PersonAddressService {

    @Override
    public PersonAddress findById(String s) {
         return new PersonAddressRepositoryImpl().findById(s);
    }

    @Override
    public PersonAddress save(PersonAddress entity) {
         return new PersonAddressRepositoryImpl().save(entity);
    }

    @Override
    public PersonAddress update(PersonAddress entity) {
       return new PersonAddressRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonAddress entity) {
        new PersonAddressRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonAddress> findAll() {
        return new PersonAddressRepositoryImpl().findAll();
    }

}
