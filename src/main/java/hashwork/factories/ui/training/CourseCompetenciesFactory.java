package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CourseCompetencies;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseCompetenciesFactory {
    public static CourseCompetencies getCourseCompetencies(String courseId, String competencyId) {
        CourseCompetencies courseCompetencies = new CourseCompetencies.Builder()
                .id(KeyGenerator.getEntityId())
                .courseId(courseId)
                .competencyid(competencyId)
                .build();
        return courseCompetencies;
    }
}
