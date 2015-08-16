package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyRequest implements Serializable {

    private String id;
    private String competencyName;
    private String competencyId;
    private Date requestDate;
    private String requestorName;
    private String requestorId;
    //PENDING, APPROVED, REJECTED,FULLFILEED
    private String status;
    private String rejectComment;
}
