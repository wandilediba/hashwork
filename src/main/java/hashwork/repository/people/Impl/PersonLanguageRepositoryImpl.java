/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.domain.people.PersonLanguage;
import hashwork.repository.people.PersonLanguageRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;;

/**
 *
 * @author BONGANI
 */
public class PersonLanguageRepositoryImpl implements PersonLanguageRepository{
Map<String, PersonLanguage> lists = new HashMap<>();

   public PersonLanguageRepositoryImpl() {

    }
    @Override
    public PersonLanguage findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonLanguage save(PersonLanguage entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonLanguage update(PersonLanguage entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonLanguage entity) {
      lists.remove(entity.getId());
    }

    @Override
    public Set<PersonLanguage> findAll() {
    
      Set<PersonLanguage> set = new HashSet<>();
        for (Map.Entry<String, PersonLanguage> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
