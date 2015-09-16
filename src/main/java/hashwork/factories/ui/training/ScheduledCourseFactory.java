package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.ScheduledCourse;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseFactory {
    public static ScheduledCourse getScheduledCourse(int courseCapacity,
                                                     int numOfStuds,
                                                     Date startDate,
                                                     Date endDate,
                                                     Date dateRequested,
                                                     String courseNameId,
                                                     String venue,
                                                     String status,
                                                     List<String> courseRequestors,
                                                     List<String> courseFundersIds,
                                                     Set<String> participants) {
        ScheduledCourse scheduledCourse = new ScheduledCourse.Builder()
                .id(KeyGenerator.getEntityId())
                .courseCapacity(courseCapacity)
                .numOfStuds(numOfStuds)
                .startDate(startDate)
                .endDate(endDate)
                .dateRequested(dateRequested)
                .courseNameId(courseNameId)
                .venue(venue)
                .status(status)
                .courseRequestors(courseRequestors)
                .courseFundersIds(courseFundersIds)
                .participants(participants)
                .build();
        return scheduledCourse;
    }
}
