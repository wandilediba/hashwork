package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonHiringDecision implements Serializable {
    private String id;
    private String personId;
    private Date decisionDate;
    private String decision;
    private String comments;
    private String decisionMakerId;
}
