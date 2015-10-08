/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.ScheduledCourseEvaluation;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class ScheduledCourseEvaluationTable extends Table {
    
    private final MainLayout main;

    public ScheduledCourseEvaluationTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("ScheduledCourseId", String.class, null);
        addContainerProperty("Rating", String.class, null);
        addContainerProperty("Comments", String.class, null);
     


        // Add Data Columns
        Set<ScheduledCourseEvaluation> evaluations = TrainingFacade.scheduledCourseEvaluationService.findAll();
        for (ScheduledCourseEvaluation ScheduledCourseEvaluation : evaluations) {
            addItem(new Object[]{ScheduledCourseEvaluation.getScheduledCourseId(),
                ScheduledCourseEvaluation.getRating(),
                ScheduledCourseEvaluation.getComments()
            }, ScheduledCourseEvaluation.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
