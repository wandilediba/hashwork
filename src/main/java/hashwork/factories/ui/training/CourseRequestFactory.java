package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CourseRequest;

import java.util.Date;
import java.util.List;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseRequestFactory {
    public static CourseRequest getCourseRequest(String requestName,
                                                 List<String> requestorsIds,
                                                 List<String> competenciesIds,
                                                 Date prefferedStart,
                                                 Date preferredEnd,
                                                 Date requestedDate,
                                                 List<String> funderIds,
                                                 List<String> trainingInstitutionsId,
                                                 String status) {
        CourseRequest courseRequest = new CourseRequest.Builder()
                .id(KeyGenerator.getEntityId())
                .requestName(requestName)
                .requestorsIds(requestorsIds)
                .competenciesIds(competenciesIds)
                .prefferedStart(prefferedStart)
                .prefferedEnd(preferredEnd)
                .requestedDate(requestedDate)
                .funderIds(funderIds)
                .trainingInstitutionsId(trainingInstitutionsId)
                .status(status)
                .build();
        return courseRequest;
    }
}
