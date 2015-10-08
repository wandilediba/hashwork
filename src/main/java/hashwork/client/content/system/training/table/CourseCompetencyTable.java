package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CourseCompetencies;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CourseCompetencyTable extends Table {
    private final MainLayout main;

    public CourseCompetencyTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Course Id", String.class, null);
        addContainerProperty("Competency Id", String.class, null);

        Set<CourseCompetencies> courseCompetencies = TrainingFacade.courseCompetenciesService.findAll();
        for(CourseCompetencies courseCompetency: courseCompetencies){
            addItem(new Object[]{courseCompetency.getCourseId(),
                    courseCompetency.getCompetencyId()},
                    courseCompetency.getId());
        }
    }
}