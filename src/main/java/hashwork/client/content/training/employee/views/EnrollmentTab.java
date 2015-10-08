package hashwork.client.content.training.employee.views;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.PersonFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.training.employee.forms.TrainingEnrollmentForm;
import hashwork.client.content.training.employee.table.ScheduledCourseApprovedTable;
import hashwork.domain.people.Person;
import hashwork.domain.ui.training.ScheduledCourse;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hashcode on 2015/10/08.
 */
public class EnrollmentTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HashWorkMain main;
    private final TrainingEnrollmentForm form;
    private final ScheduledCourseApprovedTable table;
    private String scheduledCourseId;
    private Collection<String> participantIds = new ArrayList<String>();

    public EnrollmentTab(HashWorkMain app) {
        main = app;
        form = new TrainingEnrollmentForm(main);
        table = new ScheduledCourseApprovedTable(main);
        setSizeFull();
        addComponent(table);
        addComponent(form);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.enroll) {
            if (scheduledCourseId != null) {
                enrolPaticipants(scheduledCourseId, participantIds);
                getHome();
            } else {
                Notification.show("NO COURSE SCHEDULE SELECTED!", Notification.Type.WARNING_MESSAGE);
            }
        } else {
            getHome();
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            scheduledCourseId = (String) property.getValue();
        }
        if (property == form.select) {
            Collection<String> ids = (Collection<String>) property.getValue();
            participantIds = ids;
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new EmployeeTrainingMenu(main, "SCHEDULED"));
    }

    private void addListeners() {
        //Register Button Listeners
        form.cancel.addClickListener((ClickListener) this);
        form.enroll.addClickListener((ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
        form.select.addValueChangeListener((ValueChangeListener) this);
    }

    private void enrolPaticipants(String scheduledCourseId, Collection<String> participantIds) {
        ScheduledCourse scheduledCourse = TrainingFacade.getCourseScheduleModelService().findById(scheduledCourseId);
        for (String string : participantIds) {
            Person person = PersonFacade.getEmployeeModelService().findById(string);
            scheduledCourse.getParticipants().add(person);
        }
        TrainingFacade.getCourseScheduleModelService().merge(scheduledCourse);
    }
}
