/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonInterviewFeedback;
import java.util.Date;

/**
 *
 * @author BONGANI
 */
public class PersonInterviewFeedbackFactory {
    
     public static PersonInterviewFeedback getPersonInterviewFeedback(String personId,
                                                                      String penalistId,
                                                                      Date intervieDate,
                                                                      String comments,
                                                                      int rating)
    {
        PersonInterviewFeedback personFeedback = new PersonInterviewFeedback.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .penalistId(penalistId)
                .intervieDate(intervieDate)
                .comments(comments)
                .rating(rating)                
                .build();
                
      return personFeedback;
    }
}

  