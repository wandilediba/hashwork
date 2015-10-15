package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.ContinuingEducationCourse;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class ContinuingEducationCouseTable extends Table {
    private final MainLayout main;

    public ContinuingEducationCouseTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Course Name", String.class, null);
        addContainerProperty("Credit Hours", String.class, null);

        Set<ContinuingEducationCourse> continuingEducationCourses = TrainingFacade.continuingEducationCourseService.findAll();
        for (ContinuingEducationCourse continuingEducationCourse : continuingEducationCourses) {
            addItem(new Object[]{continuingEducationCourse.getCourseName(),
                            continuingEducationCourse.getCreditHours()},
                    getCurrentPageFirstItemId());
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }
}
