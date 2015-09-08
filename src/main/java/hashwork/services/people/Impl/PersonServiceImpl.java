/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.Person;
import hashwork.repository.people.Impl.PersonRepositoryImpl;
import hashwork.repository.people.PersonRepository;
import hashwork.services.people.PersonService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repo = new PersonRepositoryImpl();

    @Override
    public Person findById(String s) {
        return repo.findById(s);
    }

    @Override
    public Person save(Person entity) {
        return repo.save(entity);
    }

    @Override
    public Person update(Person entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Person entity) {
        repo.delete(entity);
    }

    @Override
    public Set<Person> findAll() {
        return repo.findAll();
    }

}
