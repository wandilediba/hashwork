package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.ScheduledCourseRequestor;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseRequestorFactory {
    public static ScheduledCourseRequestor getAddressType(String scheduledCourseId, String requesterId) {
        ScheduledCourseRequestor scheduledCourseRequestor = new ScheduledCourseRequestor.Builder()
                .id(KeyGenerator.getEntityId())
                .scheduledCourseId(scheduledCourseId)
                .requesterId(requesterId).build();
        return scheduledCourseRequestor;
    }
}
