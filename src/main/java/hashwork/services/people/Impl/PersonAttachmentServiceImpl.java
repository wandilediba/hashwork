/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.Person;
import hashwork.domain.people.PersonAttachment;
import hashwork.repository.people.Impl.PersonAttachmentRepositoryImpl;
import hashwork.repository.people.PersonAttachmentRepository;
import hashwork.services.people.PersonAddressService;
import hashwork.services.people.PersonAttachmentService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonAttachmentServiceImpl implements PersonAttachmentService {
 
    @Override
    public PersonAttachment findById(String s) {
          return new PersonAttachmentRepositoryImpl().findById(s);
    }

    @Override
    public PersonAttachment save(PersonAttachment entity) {
        return new PersonAttachmentRepositoryImpl().save(entity);
    }

    @Override
    public PersonAttachment update(PersonAttachment entity) {
         return new PersonAttachmentRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonAttachment entity) {
         new PersonAttachmentRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonAttachment> findAll() {
       return new PersonAttachmentRepositoryImpl().findAll();
    }

}
