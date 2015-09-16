package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.ContinuingEducationCourse;

/**
 * Created by garran on 2015/09/13.
 */
public class ContinuingEducationCourseFactory {
    public static ContinuingEducationCourse getContinuingEducationCourse(String courseName, int creditHours) {
        ContinuingEducationCourse addressType = new ContinuingEducationCourse.Builder()
                .id(KeyGenerator.getEntityId())
                .courseName(courseName)
                .creditHours(creditHours)
                .build();
        return addressType;
    }
}
