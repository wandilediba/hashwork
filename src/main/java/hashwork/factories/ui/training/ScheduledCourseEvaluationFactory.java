package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.ScheduledCourseEvaluation;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseEvaluationFactory {
    public static ScheduledCourseEvaluation getScheduledCourseEvaluation(String scheduledCourseId, int rating, String comments) {
        ScheduledCourseEvaluation scheduledCourseEvaluation = new ScheduledCourseEvaluation.Builder()
                .id(KeyGenerator.getEntityId())
                .scheduledCourseId(scheduledCourseId)
                .rating(rating)
                .comments(comments)
                .build();
        return scheduledCourseEvaluation;
    }
}
