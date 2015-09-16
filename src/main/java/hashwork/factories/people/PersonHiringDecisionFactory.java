/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonHiringDecision;
import java.util.Date;

/**
 *
 * @author BONGANI
 */
public class PersonHiringDecisionFactory {
    
     public static PersonHiringDecision getPersonHiringDecision ( String personId,
                                                                Date decisionDate,
                                                                String decision,
                                                                String comments,
                                                                String decisionMakerId)
    {
        PersonHiringDecision hiringDecision = new PersonHiringDecision.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .decisionMakerId(decisionMakerId)
                .decision(decision)
                .decisionDate(decisionDate)
                .comments(comments)                
                .build();
                
      return hiringDecision;
    
    }
    
}


    