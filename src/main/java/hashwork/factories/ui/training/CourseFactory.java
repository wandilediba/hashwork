package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.Course;

import java.util.List;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseFactory {
    public static Course getCourse(String courseName, String courseCategoryId, String courseTopic, String institutionNameId, String courseStatusId, String courseObjective, int creditHours, List<String> courseCompetenciesId ) {
        Course course = new Course.Builder()
                .id(KeyGenerator.getEntityId())
                .courseName(courseName)
                .courseCategoryId(courseCategoryId)
                .courseTopic(courseTopic)
                .institutionNameId(institutionNameId)
                .courseStatusId(courseStatusId)
                .courseObjective(courseObjective)
                .creditHours(creditHours)
                .courseCompetenciesId(courseCompetenciesId)
                .build();
        return course;
    }
}
