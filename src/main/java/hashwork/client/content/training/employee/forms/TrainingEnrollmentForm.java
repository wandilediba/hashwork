package hashwork.client.content.training.employee.forms;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TwinColSelect;
import hashwork.app.facade.TrainingFacade;
import hashwork.domain.people.Person;

import java.util.Collections;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingEnrollmentForm extends FormLayout {

    private final HashWorkMain main;
    public Button enroll = new Button("Enroll Participants");
    public Button cancel = new Button("Cancel");
    public final TwinColSelect select = new TwinColSelect();
    private final HorizontalLayout buttons = new HorizontalLayout();

    public TrainingEnrollmentForm(HashWorkMain main) {
        this.main = main;
        enroll.setSizeFull();
        cancel.setSizeFull();

        select.setSizeFull();

        buttons.setSizeFull();
        buttons.addComponent(enroll);
        buttons.addComponent(cancel);

        // Set the column captions (optional)
        select.setLeftColumnCaption("Select Attendees");
        select.setRightColumnCaption("Attendees for Enrolment");

        // Put some data in the select
        List<Person> people = TrainingFacade.getCourseService().getPeopleUnderMySupervison();
        Collections.sort(people);
        for (Person person : people) {
            select.setItemCaption(person.getId(), person.getLastName() + "  " + person.getFirstName());
            select.addItem(person.getId());
        }

        // Set the number of visible items
        select.setRows(people.size());
        addComponent(select);
        addComponent(buttons);

    }

}
