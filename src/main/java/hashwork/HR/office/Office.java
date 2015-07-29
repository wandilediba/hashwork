package hashwork.HR.office;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by hashcode on 2015/07/25.
 */
public class Office implements Serializable{
    private String id;
    private String name;
    private String description;
    private String active;
    private Date dateEstablished;
    private String officeTypeId;
    private String cityId;
    private String contactId;
    private Set<String> positionIds;
}
