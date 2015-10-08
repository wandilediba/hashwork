package hashwork.client.content.training.institutions.table;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.Course;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class ParticipantsTable extends Table {

    private final MainLayout main;

    public ParticipantsTable(MainLayout app) {
        this.main = app;
        setSizeFull();


        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Last Name", String.class, null);
        addContainerProperty("Status ", String.class, null);
        addContainerProperty("Assess", Button.class, null);


        // Add Data Columns
        List<Course> courses = TrainingFacade.getCourseService().getInstitutionCourses();
        for (final Course course : courses) {

            Button delete = new Button("Delete", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    if (course.getScheduledCourses().size() > 0) {
                        Notification.show("Course Has Schedule, Delete Schedule First!", Notification.Type.ERROR_MESSAGE);
                    } else {
                        TrainingFacade.getCourseModelService().remove(course);
                        main.content.setSecondComponent(new InstitutionManagementMenu(main, "CREATE"));
                    }

                }
            });


            delete.setStyleName(Reindeer.BUTTON_LINK);


            addItem(new Object[]{course.getCourseName(),
                    course.getCourseCategory().getCategoryName(),
                    course.getInstitutionName().getTrainingInstitution(),
                    course.getCourseStatus().getStatusValues(),
                    course.getCreditHours(),
                    delete
            }, course.getId());
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
}
