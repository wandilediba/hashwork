/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonIdentity;

/**
 *
 * @author BONGANI
 */
public class PersonIdentityFactory {
    
     public static PersonIdentity getPersonIdentity (String personId,
                                                    String idType,
                                                    String idValue,
                                                    boolean preffered)
    {
        PersonIdentity personIdentity = new PersonIdentity.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .idType(idType)
                .idValue(idValue)
                .preffered(preffered)
                .build();
                
      return personIdentity;
    
    }
    
    
}
