package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonEducationHistory implements Serializable {
    private String id;
    private String personId;
    private String institutionName;
    private String institutionLocation;
    private int yearOfGraduation;
    private String educationTypeId;
    private String degreeId;
    private String notes;
}
