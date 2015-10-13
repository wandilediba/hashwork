package hashwork.services.ui.training;

import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.services.Services;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public interface ScheduledCourseService extends Services<ScheduledCourse, String> {
    public Set<ScheduledCourse> getApprovedScheduledCourse();

}
