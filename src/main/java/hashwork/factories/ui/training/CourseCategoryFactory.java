package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CourseCategory;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseCategoryFactory {
    public static CourseCategory getCourseCategory(String categoryName) {
        CourseCategory courseCategory = new CourseCategory.Builder()
                .id(KeyGenerator.getEntityId())
                .categoryName(categoryName)
                .build();
        return courseCategory;
    }
}
