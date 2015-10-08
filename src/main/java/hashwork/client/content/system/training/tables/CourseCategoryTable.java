package hashwork.client.content.system.training.tables;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CourseCategory;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseCategoryTable extends Table {


    private final MainLayout main;

    public CourseCategoryTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Course Category Name", String.class, null);

        // Add Data Columns
        Set<CourseCategory> courseCategorys = TrainingFacade.courseCategoryService.findAll();
        for (CourseCategory courseCategory : courseCategorys) {
            addItem(new Object[]{courseCategory.getCategoryName()}, courseCategory.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
