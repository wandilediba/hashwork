/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonContinuingEducation;

/**
 *
 * @author BONGANI
 */
public class PersonContinuingEducationFactory {
    
    public static PersonContinuingEducation getPersonContinuingEducation (  String personId,
                                                                            String courseId,
                                                                            String competencyEvaluationId,
                                                                            String courseScheduleId)
    {
        PersonContinuingEducation education = new PersonContinuingEducation.Builder()               
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .courseId(courseId)
                .competencyEvaluationId(competencyEvaluationId)
                .courseScheduleId(courseScheduleId)                
                .build();
                
      return education;
    
    }
    
}

