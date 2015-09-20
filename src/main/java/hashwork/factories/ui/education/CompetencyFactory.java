/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.education;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.education.Competency;

/**
 *
 * @author BKLAAS1
 */
public class CompetencyFactory {
    
     public static Competency getCompetency(String name,String competencyTypeId,String notes) {
        Competency competency = new Competency
                .Builder()
                .id(KeyGenerator.getEntityId())
                .competencyTypeId(competencyTypeId)
                .name(name)
                .Notes(notes) 
                .build();
        return competency;
    }
    
}


  