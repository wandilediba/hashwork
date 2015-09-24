package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.ScheduledCourseRequestor;

/**
 * Created by Rosie on 2015/09/23.
 */
public class ScheduledCourseRequestorForm extends FormLayout {
    private final ScheduledCourseRequestor bean;
    public final BeanItem<ScheduledCourseRequestor> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ScheduledCourseRequestorForm() {
        bean = new ScheduledCourseRequestor();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", ScheduledCourseRequestor.class, binder);

        TextField scourse = UIComponent.getTextField("Scheduled Course ID :", "scheduledCourseId", ScheduledCourseRequestor.class, binder);
        TextField reqid = UIComponent.getTextField("Requester ID :", "requesterId", ScheduledCourseRequestor.class, binder);

        addComponent(id);
        addComponent(scourse);
        addComponent(reqid);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
