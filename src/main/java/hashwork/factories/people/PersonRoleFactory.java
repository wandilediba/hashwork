/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonRole;

/**
 *
 * @author BONGANI
 */
public class PersonRoleFactory {
     public static PersonRole getPersonRole (String persondId,String roleId)
    {
        PersonRole personRole = new PersonRole.Builder()
                .id(KeyGenerator.getEntityId())
                .persondId(persondId)
                .roleId(roleId)               
                .build();
                
      return personRole;
    
    }
    
}
