package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.Course;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CourseTable extends Table {
    private final MainLayout main;

    public CourseTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("CourseName", String.class, null);
        addContainerProperty("CourseStatusId", String.class, null);
        addContainerProperty("CourseTopic", String.class, null);
        addContainerProperty("CreditHours", String.class, null);
        addContainerProperty("InstitutionNameId", String.class, null);
        addContainerProperty("CourseCategoryId", String.class, null);
        addContainerProperty("CourseCompetenciesId", String.class, null);

        // Add Data Columns
        Set<Course> courses = TrainingFacade.courseService.findAll();
        for (Course course : courses) {
            addItem(new Object[]{course.getCourseName(),
                            course.getCourseStatusId(),
                            course.getCourseTopic(),
                            course.getCreditHours(),
                            getInstitutionName(course.getInstitutionNameId()),
                            getCourseCategory(course.getCourseCategoryId()),
                            course.getCourseCompetenciesId()},
                    course.getId());
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }


    private String getInstitutionName(String institutionNameId) {
        if (institutionNameId != null) {
            return TrainingFacade.courseService.findById(institutionNameId).getCourseName();
        }
        return null;
    }

    private String getCourseCategory(String courseCategoryId) {
        if (courseCategoryId != null) {
            return TrainingFacade.courseCategoryService.findById(courseCategoryId).getCategoryName();
        }
        return null;
    }

}
