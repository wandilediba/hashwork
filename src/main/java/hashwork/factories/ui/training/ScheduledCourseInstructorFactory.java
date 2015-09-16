package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.ScheduledCourseInstructor;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseInstructorFactory {
    public static ScheduledCourseInstructor getScheduledCourseInstructor(String ScheduledCourseId, String trainerId) {
        ScheduledCourseInstructor scheduledCourseInstructor = new ScheduledCourseInstructor.Builder()
                .id(KeyGenerator.getEntityId())
                .scheduledCourseId(ScheduledCourseId)
                .trainerId(trainerId).build();
        return scheduledCourseInstructor;
    }
}
