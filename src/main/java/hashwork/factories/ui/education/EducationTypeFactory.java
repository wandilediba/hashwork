/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.education;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.education.EducationType;

/**
 *
 * @author BKLAAS1
 */
public class EducationTypeFactory {
     public static EducationType getEducation(String name) {
        EducationType genderList = new EducationType
                .Builder()
                .id(KeyGenerator.getEntityId())
                .name(name).build();
        return genderList;
    }
}
