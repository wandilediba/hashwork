package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.Position;

import java.util.Date;
import java.util.List;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionFactory {
    public static Position getAddressType(String addressTypeName,
                                          String positionCode,
                                          String positionTitle,
                                          String description,
                                          Date postionEntryDate,
                                          Date positionEndDate,
                                          String currentOccupantId,
                                          String positionTypeId,
                                          String positionStatusId,
                                          String positionComments,
                                          String officeId,
                                          List<String> subodinateIds,
                                          String supervisorId,
                                          String departmentId,
                                          String jobId) {
        Position position = new Position.Builder()
                .id(KeyGenerator.getEntityId())
                .positionCode(positionCode)
                .positionTitle(positionTitle)
                .description(description)
                .postionEntryDate(postionEntryDate)
                .positionEndDate(positionEndDate)
                .currentOccupantId(currentOccupantId)
                .positionTypeId(positionTypeId)
                .positionStatusId(positionStatusId)
                .positionComments(positionComments)
                .officeId(officeId)
                .subodinateIds(subodinateIds)
                .supervisorId(supervisorId)
                .departmentId(departmentId)
                .jobId(jobId)
                .build();
        return position;
    }
}
