/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonAttachment;

/**
 *
 * @author BONGANI
 */
public class PersonAttachmentFactory {
    
     public static PersonAttachment getPersonAttachment (String personId,String fileName)
    {
        PersonAttachment personAttachment = new PersonAttachment.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .fileName(fileName)                
                .build();
                
      return personAttachment;
    
    }    
    
}


  