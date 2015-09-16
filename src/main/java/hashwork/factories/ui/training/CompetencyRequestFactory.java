package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CompetencyRequest;

import java.util.Date;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyRequestFactory {
    public static CompetencyRequest getCompetencyRequest(String competencyName, String competencyId, Date requestDate, String requestorName, String requestorId, String status, String rejectComment) {
        CompetencyRequest competencyRequest = new CompetencyRequest.Builder()
                .id(KeyGenerator.getEntityId())
                .competencyName(competencyName)
                .competencyId(competencyId)
                .requestDate(requestDate)
                .requestorName(requestorName)
                .requestorId(requestorId)
                .status(status)
                .rejectComment(rejectComment)
                .build();
        return competencyRequest;
    }
}
