/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonEducationHistory;
import hashwork.repository.people.Impl.PersonEducationHistoryRepositoryImpl;
import hashwork.repository.people.PersonEducationHistoryRepository;
import hashwork.services.people.PersonEducationHistoryService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class PersonEducationHistoryServiceImpl implements PersonEducationHistoryService{
     private final PersonEducationHistoryRepository repo = new PersonEducationHistoryRepositoryImpl();
    @Override
    public PersonEducationHistory findById(String s) {
       return repo.findById(s);
    }

    @Override
    public PersonEducationHistory save(PersonEducationHistory entity) {
        return repo.save(entity);
    }

    @Override
    public PersonEducationHistory update(PersonEducationHistory entity) {
         return repo.save(entity);
    }

    @Override
    public void delete(PersonEducationHistory entity) {
          repo.delete(entity);
    }

    @Override
    public Set<PersonEducationHistory> findAll() {
         return repo.findAll();
    }
    
}
