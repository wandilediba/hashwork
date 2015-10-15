/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.training.institutions.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.ScheduledCourse;

import java.util.Date;
import java.util.Set;

/**
 * @author BONGANI
 */
public class ScheduledCourseTable extends Table {

    private final MainLayout main;

    public ScheduledCourseTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("CourseNameId", String.class, null);
        addContainerProperty("CourseFundersIds", String.class, null);
        addContainerProperty("CourseCapacity", String.class, null);
        addContainerProperty("CourseRequestors", String.class, null);
        addContainerProperty("DateRequested", String.class, null);
        addContainerProperty("EndDate", Date.class, null);
        addContainerProperty("NumOfStuds", String.class, null);
        addContainerProperty("Participants", String.class, null);
        addContainerProperty("StartDate", Date.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Venue", String.class, null);


        // Add Data Columns
        Set<ScheduledCourse> scheduledCourses = TrainingFacade.scheduledCourseService.findAll();
        for (ScheduledCourse scheduledCourse : scheduledCourses) {
            addItem(new Object[]{scheduledCourse.getCourseNameId(),
                            scheduledCourse.getCourseFundersIds(),
                            scheduledCourse.getCourseCapacity(),
                            scheduledCourse.getCourseRequestors(),
                            scheduledCourse.getDateRequested(),
                            scheduledCourse.getEndDate(),
                            scheduledCourse.getNumOfStuds(),
                            scheduledCourse.getParticipants(),
                            scheduledCourse.getStartDate(),
                            scheduledCourse.getStatus(),
                            scheduledCourse.getVenue()},
                    scheduledCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }

}
