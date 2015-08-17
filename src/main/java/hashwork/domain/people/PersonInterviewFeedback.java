package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonInterviewFeedback implements Serializable {
    private String id;
    private String personId;
    private String penalistId;
    private Date intervieDate;
    private String comments;
    private int rating;

}
