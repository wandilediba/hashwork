package hashwork.factories.ui.education;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.education.Degree;

/**
 * Created by hashcode on 2015/08/16.
 */
public class DegreeFactory {
    
    
     public static Degree getDegree(String studyField,String educationTypeId,String degreeName) {
        Degree degree = new Degree
                .Builder()
                .id(KeyGenerator.getEntityId())
                .degreeName(degreeName).educationTypeId(educationTypeId).studyField(studyField)
                .build();
        return degree;
    }
}


     