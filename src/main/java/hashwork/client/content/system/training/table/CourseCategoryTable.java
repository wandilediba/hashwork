package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CourseCategory;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CourseCategoryTable  extends Table {
    private final MainLayout main;

    public CourseCategoryTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Category Name", String.class, null);

        Set<CourseCategory> courseCategorys = TrainingFacade.courseCategoryService.findAll();
        for(CourseCategory courseCategory: courseCategorys){
            addItem(new Object[]{courseCategory.getCategoryName()},
                    courseCategory.getId()
            );
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }
}
