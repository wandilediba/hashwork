/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonAddress;

/**
 *
 * @author BONGANI
 */

public class PersonAddressFactory {
    
    public static PersonAddress getPersonAddress (String personId,String description,String postalCode,String addressTypeId)
    {
        PersonAddress personAddress = new PersonAddress.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .description(description)
                .addressTypeId(addressTypeId)
                .postalCode(postalCode)
                .build();
                
      return personAddress;
    
    }
    
}