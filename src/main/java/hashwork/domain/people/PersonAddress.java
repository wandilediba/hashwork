package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonAddress implements Serializable {
    private String id;
    private String personId;
    private String description;
    private String postalCode;
    private String addressTypeId;
}
