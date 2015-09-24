/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonLanguage;
import hashwork.repository.people.Impl.PersonLanguageRepositoryImpl;
import hashwork.repository.people.PersonLanguageRepository;
import hashwork.services.people.PersonLanguageService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonLanguageServiceImpl implements PersonLanguageService {
   // private final PersonLanguageRepository repo = new PersonLanguageRepositoryImpl();

    @Override
    public PersonLanguage findById(String s) {
        return new PersonLanguageRepositoryImpl().findById(s);
    }

    @Override
    public PersonLanguage save(PersonLanguage entity) {
       return new PersonLanguageRepositoryImpl().save(entity);
    }

    @Override
    public PersonLanguage update(PersonLanguage entity) {
       return new PersonLanguageRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonLanguage entity) {
         new PersonLanguageRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonLanguage> findAll() {
       return new PersonLanguageRepositoryImpl().findAll();
    }

}
