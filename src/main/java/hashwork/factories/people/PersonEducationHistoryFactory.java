/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonEducationHistory;

/**
 *
 * @author BONGANI
 */
public class PersonEducationHistoryFactory {
    
    public static PersonEducationHistory getPersonEducationHistory (String personId,
                                                                    String institutionName,
                                                                    String institutionLocation,
                                                                    int yearOfGraduation,
                                                                    String educationTypeId,
                                                                    String degreeId,
                                                                    String notes )
    {
        PersonEducationHistory personEducationHistory = new PersonEducationHistory.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .institutionName(institutionName)
                .institutionLocation(institutionLocation)
                .degreeId(degreeId)
                .educationTypeId(educationTypeId)
                .yearOfGraduation(yearOfGraduation)
                .notes(notes)
                .build();
                
      return personEducationHistory;
    
    }
   
}


