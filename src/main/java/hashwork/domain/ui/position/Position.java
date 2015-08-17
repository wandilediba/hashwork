package hashwork.domain.ui.position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Position implements Serializable, Comparable<Position> {
    private static long serialVersionUID = 1L;
    private String id;
    private String positionCode;
    //Make it from Job and Position Title Nurse-Code
    private String positionTitle;
    private String description;
    private Date postionEntryDate;
    private Date positionEndDate;
    private String currentOccupantId;

    private String positionTypeId;

    private String positionStatusId;
    private String positionComments;

    private String officeId;
    private List<String> subodinateIds = new ArrayList<String>();

    private String supervisorId; // PositionId

    private String departmentId;

    private String jobId;


    @Override
    public int compareTo(Position o) {
        return positionTitle.compareTo(o.positionTitle);
    }
}
