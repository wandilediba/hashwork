package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.ScheduledCourseInstructor;

/**
 * Created by Rosie on 2015/09/23.
 */
public class ScheduledCourseInstructorForm extends FormLayout {

    private final ScheduledCourseInstructor bean;
    public final BeanItem<ScheduledCourseInstructor> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ScheduledCourseInstructorForm() {
        bean = new ScheduledCourseInstructor();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", ScheduledCourseInstructor.class, binder);

        TextField scourse = UIComponent.getTextField("Scheduled Course ID :", "ScheduledCourseId", ScheduledCourseInstructor.class, binder);
        TextField trainerid = UIComponent.getTextField("Trainer ID :", "trainerId", ScheduledCourseInstructor.class, binder);

        addComponent(id);
        addComponent(scourse);
        addComponent(trainerid);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
