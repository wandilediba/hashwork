package hashwork.client.content.training.employee.forms;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TwinColSelect;
import hashwork.app.facade.PersonFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.people.Person;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingEnrollmentForm extends FormLayout {

    private final MainLayout main;
    public Button enroll = new Button("Enroll Participants");
    public Button cancel = new Button("Cancel");
    public final TwinColSelect select = new TwinColSelect();
    private final HorizontalLayout buttons = new HorizontalLayout();

    public TrainingEnrollmentForm(MainLayout main) {
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
//        Set<Person> people = TrainingFacade.courseService.getPeopleUnderMySupervison();
        Set<Person> people = PersonFacade.personService
                .findAll()
                .stream()
                .sorted((p1, p2) -> p2.getLastName().compareTo(p1.getLastName()))
                .collect(Collectors.toSet());

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
