package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.locations.model.RegistrationBodyModel;


/**
 * Created by hashcode on 2015/09/07.
 */
public class RegistrationBodyForm extends FormLayout {
    private final RegistrationBodyModel bean;
    public final BeanItem<RegistrationBodyModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public RegistrationBodyForm() {
        bean = new RegistrationBodyModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField name = UIComponent.getTextField("Name :", "name", RegistrationBodyModel.class, binder);
        TextField description = UIComponent.getTextField("Description :", "description", RegistrationBodyModel.class, binder);
        TextField coreActivity = UIComponent.getTextField("Core Activity :", "coreActivity", RegistrationBodyModel.class, binder);
        TextField active = UIComponent.getTextField("Active :", "active", RegistrationBodyModel.class, binder);
        DateField date = UIComponent.getDateField("Date Created :", "asOfDate", RegistrationBodyModel.class, binder);

        addComponent(name);
        addComponent(description);
        addComponent(coreActivity);
        addComponent(active);
        addComponent(date);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
