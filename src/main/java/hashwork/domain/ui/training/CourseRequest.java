package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseRequest implements Serializable {

    private String id;
    private String requestName;

    private List<String> requestorsIds; //People Who requested Course

    private List<String> competenciesIds;
    private Date prefferedStart;
    private Date preferredEnd;
    private Date requestedDate;
    private List<String> funderIds;
    private List<String> trainingInstitutionsId;
    private String status;
    // REQUESTED, //CREATED  //SCHEDULED
}
