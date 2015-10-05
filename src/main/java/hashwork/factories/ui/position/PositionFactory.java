package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.Position;

import java.util.Date;
import java.util.Map;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionFactory {

//    private String positionCode;
//
//    private String positionTitle;
//    private String description;
//    private Date postionEntryDate;
//    private Date positionEndDate;
//    private String currentOccupantId;
//
//    private String positionTypeId;
//
//    private String positionStatusId;
//    private String positionComments;
//
//    private String officeId;
//    private String supervisorId; // PositionId
//
//    private String departmentId;
//
//    private String jobId;

    public static Position getPosition(Map<String, String> values, Map<String, Date> dates) {
        Position position = new Position.Builder()
                .id(KeyGenerator.getEntityId())
                .positionCode(values.get("positionCode"))
                .positionTitle(values.get("positionTitle"))
                .description(values.get("description"))
                .postionEntryDate(dates.get("postionEntryDate"))
                .positionEndDate(dates.get("positionEndDate"))
                .currentOccupantId(values.get("currentOccupantId"))
                .positionTypeId(values.get("positionTypeId"))
                .positionStatusId(values.get("positionStatusId"))
                .positionComments(values.get("positionComments"))
                .officeId(values.get("officeId"))
                .supervisorId(values.get("supervisorId"))
                .departmentId(values.get("departmentId"))
                .jobId(values.get("jobId"))
                .build();
        return position;
    }
}
