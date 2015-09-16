/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonContact;

/**
 * @author BONGANI
 */
public class PersonContactFactory {
    
    public static PersonContact getPersonContact ( String personId,String addressTypeId,String contactValue,String status)
    {
        PersonContact personContact = new PersonContact.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .contactValue(contactValue)
                .addressTypeId(addressTypeId)
                .status(status)
                .build();
                
      return personContact;
    
    }

}

