/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.domain.people.PersonAttachment;
import hashwork.repository.people.PersonAttachmentRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;


/**
 * @author BONGANI
 */
public class PersonAttachmentRepositoryImpl implements PersonAttachmentRepository {

    Redisson redisson = Connection.getConnection();
    RMap<String, PersonAttachment> lists = redisson.getMap("addresstype");
    
    public PersonAttachmentRepositoryImpl() {

    }

    @Override
    public PersonAttachment findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonAttachment save(PersonAttachment entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonAttachment update(PersonAttachment entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonAttachment entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonAttachment> findAll() {
        Set<PersonAttachment> set = new HashSet<>();
        for (Map.Entry<String, PersonAttachment> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }


}
