package hashwork.client.content.training.employee.table;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.ScheduledCourse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class ScheduledCourseApprovedTable extends Table {
    private final MainLayout main;

    public ScheduledCourseApprovedTable(MainLayout main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Course Name", String.class, null);
        addContainerProperty("Capacity", Integer.class, null);
        addContainerProperty("Enrollments ", Integer.class, null);
        addContainerProperty("Venue ", String.class, null);
        addContainerProperty("Status ", String.class, null);
        addContainerProperty("Start Date", Date.class, null);
        addContainerProperty("End Date ", Date.class, null);

        // Add Data Columns
        List<ScheduledCourse> scheduledCourses = TrainingFacade.getCourseService().getApprovedScheduledCourse();
        for (ScheduledCourse scheduledCourse : scheduledCourses) {
            addItem(new Object[]{
                    scheduledCourse.getCourseName().getCourseName(),
                    scheduledCourse.getCourseCapacity(),
                    scheduledCourse.getNumOfStuds(),
                    scheduledCourse.getVenue(),
                    getStatus(scheduledCourse),
                    scheduledCourse.getStartDate(),
                    scheduledCourse.getEndDate()
            }, scheduledCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    @Override
    protected String formatPropertyValue(Object rowId, Object colId, Property<?> property) {
        // Format by property type
        if (property.getType() == Date.class) {
            SimpleDateFormat df =
                    new SimpleDateFormat("EEE MMM dd ");
            return df.format((Date) property.getValue());
        }

        return super.formatPropertyValue(rowId, colId, property);
    }

    private String getStatus(ScheduledCourse scheduledCourse) {
        if (scheduledCourse.getCourseCapacity() >= scheduledCourse.getNumOfStuds()) {
            return "OPEN";
        }
        return "FULL";

    }
}
