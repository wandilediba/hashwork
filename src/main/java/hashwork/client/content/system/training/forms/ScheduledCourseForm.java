package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
//import hashwork.client.content.system.locations.model.LocationModel;
import hashwork.client.content.system.training.model.ScheduledCourse;
import com.vaadin.ui.ComboBox;

/**
 * Created by Rosie on 2015/09/23.
 */
public class ScheduledCourseForm extends FormLayout {
    private final ScheduledCourse bean;
    public final BeanItem<ScheduledCourse> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ScheduledCourseForm() {
        bean = new ScheduledCourse();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", ScheduledCourse.class, binder);

        TextField name = UIComponent.getTextField("Course Capacity :", "courseCapacity", ScheduledCourse.class, binder);
        TextField stud = UIComponent.getTextField("Number of students :", "numOfStud", ScheduledCourse.class, binder);
        TextField venue = UIComponent.getTextField("Venue :", "numOfStud", ScheduledCourse.class, binder);
        TextField stat = UIComponent.getTextField("Status :", "numOfStud", ScheduledCourse.class, binder);

        DateField sdate = UIComponent.getDateField("Start Date :", "startDate", ScheduledCourse.class, binder);
        DateField fdate = UIComponent.getDateField("End Date :", "endDate", ScheduledCourse.class, binder);
        DateField rdate = UIComponent.getDateField("Date Requested:", "dateRequested", ScheduledCourse.class, binder);

        ComboBox courseNameId = UIComboBox.getLocationTypeComboBox("Course Name Id :", "courseNameId", ScheduledCourse.class, binder);
        ComboBox coursereq = UIComboBox.getLocationTypeComboBox("Course Requestors :", "courseRequestors", ScheduledCourse.class, binder);
        ComboBox coursefund = UIComboBox.getLocationTypeComboBox("Course Funders IDs :", "courseFundersIds", ScheduledCourse.class, binder);
        ComboBox ppants = UIComboBox.getLocationTypeComboBox("Participants :", "participants", ScheduledCourse.class, binder);

        addComponent(id);
        addComponent(name);
        addComponent(stud);
        addComponent(venue);
        addComponent(stat);
        addComponent(sdate);
        addComponent(fdate);
        addComponent(rdate);
        addComponent(courseNameId);
        addComponent(coursereq);
        addComponent(coursefund);
        addComponent(ppants);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
