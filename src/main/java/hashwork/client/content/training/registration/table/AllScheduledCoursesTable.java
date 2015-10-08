package hashwork.client.content.training.registration.table;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.Reindeer;
import hashwork.app.facade.TrainingFacade;
import hashwork.domain.ui.training.Course;
import hashwork.domain.ui.training.ScheduledCourse;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class AllScheduledCoursesTable extends Table {

    private final HashWorkMain main;

    public AllScheduledCoursesTable(HashWorkMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Institution", String.class, null);
        addContainerProperty("Course Name", String.class, null);
        addContainerProperty("Venue", String.class, null);
        addContainerProperty("Start Date", Date.class, null);
        addContainerProperty("End Date", Date.class, null);
        addContainerProperty("Capacity", Integer.class, null);
        addContainerProperty("Enrollment", Integer.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Competencies", Button.class, null);
        addContainerProperty("Action", Button.class, null);


        // Add Data Columns
        List<ScheduledCourse> scheduledCourses = TrainingFacade.getCourseScheduleModelService().findAll();
        for (final ScheduledCourse scheduledCourse : scheduledCourses) {


            Button competenciesButton = new Button("Competencies", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                }
            });

            competenciesButton.setStyleName(Reindeer.BUTTON_LINK);

            Button approveButton = new Button("Approve", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    scheduledCourse.setStatus("APPROVED");
                    TrainingFacade.getCourseScheduleModelService().merge(scheduledCourse);
                    getHome();
                }
            });

            approveButton.setStyleName(Reindeer.BUTTON_LINK);

            Button approvedButton = new Button("APPROVED", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                }
            });

            approvedButton.setStyleName(Reindeer.BUTTON_LINK);
            approvedButton.setDisableOnClick(true);


            addItem(new Object[]{
                    scheduledCourse.getCourseName().getInstitutionName().getTrainingInstitution(),
                    getCourseName(scheduledCourse.getCourseName()),
                    scheduledCourse.getVenue(),
                    scheduledCourse.getStartDate(),
                    scheduledCourse.getEndDate(),
                    scheduledCourse.getCourseCapacity(),
                    scheduledCourse.getNumOfStuds(),
                    getStatus(scheduledCourse),
                    competenciesButton,
                    getButton(approvedButton, approveButton, scheduledCourse)
            }, scheduledCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getCourseName(Course courseName) {
        if (courseName != null) {
            return courseName.getCourseName();
        }
        return null;
    }

    private String getStatus(ScheduledCourse scheduledCourse) {
        if (scheduledCourse.getCourseCapacity() >= scheduledCourse.getNumOfStuds()) {
            return "OPEN";
        }
        return "FULL";

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

    private Button getButton(Button approvedButton, Button approveButton, ScheduledCourse scheduledCourse) {
        if ("APPROVED".equals(scheduledCourse.getStatus())) {
            return approvedButton;
        } else {
            return approveButton;
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionRegistrationMenu(main, "SCHEDULES"));
    }
}
