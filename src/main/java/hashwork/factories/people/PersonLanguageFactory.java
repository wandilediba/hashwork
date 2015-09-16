/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonLanguage;

/**
 *
 * @author BONGANI
 */
public class PersonLanguageFactory {
    
     public static PersonLanguage getPersonLanguage (String personId,
                                                    String languageId,
                                                    String reading,
                                                    String writing,
                                                    String speaking)
    {
        PersonLanguage personLanguage = new PersonLanguage.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .languageId(languageId)
                .reading(reading)
                .speaking(speaking)
                .writing(writing)                
                .build();
                
      return personLanguage;
    
    }
    
}

 