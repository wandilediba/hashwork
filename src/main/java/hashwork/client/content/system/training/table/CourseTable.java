/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.Course;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class CourseTable extends Table{
    
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
                course.getInstitutionNameId(),
                course.getCourseCategoryId(),                
                course.getCourseCompetenciesId()}, course.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
