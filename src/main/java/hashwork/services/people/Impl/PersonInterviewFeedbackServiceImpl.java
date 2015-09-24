/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.people.Impl;

import hashwork.domain.people.PersonInterviewFeedback;
import hashwork.repository.people.Impl.PersonInterviewFeedbackRepositoryImpl;
import hashwork.repository.people.PersonInterviewFeedbackRepository;
import hashwork.services.people.PersonInterviewFeedbackService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class PersonInterviewFeedbackServiceImpl implements PersonInterviewFeedbackService {
   // private final PersonInterviewFeedbackRepository repo = new PersonInterviewFeedbackRepositoryImpl();

    @Override
    public PersonInterviewFeedback findById(String s) {
        return new PersonInterviewFeedbackRepositoryImpl().findById(s);
    }

    @Override
    public PersonInterviewFeedback save(PersonInterviewFeedback entity) {
         return new PersonInterviewFeedbackRepositoryImpl().save(entity);
    }

    @Override
    public PersonInterviewFeedback update(PersonInterviewFeedback entity) {
         return new PersonInterviewFeedbackRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PersonInterviewFeedback entity) {
        new PersonInterviewFeedbackRepositoryImpl().delete(entity);
    }

    @Override
    public Set<PersonInterviewFeedback> findAll() {
       return new PersonInterviewFeedbackRepositoryImpl().findAll();
    }

}
