/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonDemographics;
import java.util.Date;

/**
 *
 * @author BONGANI
 */
public class PersonDemographicsFactory {
    
    public static PersonDemographics getPersonDemographics (String personId,String gender, Date dateOfBirth,String maritalStatus,int numberOfDependencies )
    {
        PersonDemographics personDemographics = new PersonDemographics.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .maritalStatus(maritalStatus)
                .numberOfDependencies(numberOfDependencies)
                .build();
                
      return personDemographics;
    
    }
    
}


