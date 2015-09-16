/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.people.PersonAddress;
import hashwork.domain.people.PersonInterviewFeedback;
import hashwork.repository.people.PersonInterviewFeedbackRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 * @author BONGANI
 */
public class PersonInterviewFeedbackRepositoryImpl implements PersonInterviewFeedbackRepository {
      Redisson redisson = Connection.getConnection();
    RMap<String, PersonInterviewFeedback> lists = redisson.getMap("addresstype");
    
    public PersonInterviewFeedbackRepositoryImpl() {

    }

    @Override
    public PersonInterviewFeedback findById(String s) {
        return lists.get(s);
    }

    @Override
    public PersonInterviewFeedback save(PersonInterviewFeedback entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PersonInterviewFeedback update(PersonInterviewFeedback entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PersonInterviewFeedback entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PersonInterviewFeedback> findAll() {
        Set<PersonInterviewFeedback> set = new HashSet<>();
        for (Map.Entry<String, PersonInterviewFeedback> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
