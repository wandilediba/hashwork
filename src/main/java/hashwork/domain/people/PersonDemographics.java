package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonDemographics implements Serializable {
    private String id;
    private String personId;
    private String gender;
    private Date dateOfBirth;
    private String maritalStatus;
    private int numberOfDependencies;
}
