package hashwork.services.ui.training;

import hashwork.domain.ui.training.Course;
import hashwork.domain.ui.training.CourseRequest;
import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.services.Services;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public interface CourseService extends Services<Course, String> {
    public Set<Course> getInstitutionCourses();

    public Set<ScheduledCourse> getApprovedScheduledCourse();

    public Set<CourseRequest> getInstitutionCourseRequests();

    public Set<ScheduledCourse> getInstitutionApprovedScheduledCourses();
}
