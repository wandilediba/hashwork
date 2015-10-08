/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.ScheduledCourseInstructor;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class ScheduledCourseInstructorTable extends Table {
    
    private final MainLayout main;

    public ScheduledCourseInstructorTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("TrainerId", String.class, null);
        addContainerProperty("ScheduledCourseId", String.class, null);
       


        // Add Data Columns
        Set<ScheduledCourseInstructor> scheduledCourseInstructors = TrainingFacade.scheduledCourseInstructorService.findAll();
        for (ScheduledCourseInstructor scheduledCourseInstructor : scheduledCourseInstructors) {
            addItem(new Object[]{scheduledCourseInstructor.getTrainerId(),
            scheduledCourseInstructor.getScheduledCourseId()}, 
            scheduledCourseInstructor.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
