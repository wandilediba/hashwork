package hashwork.client.content.system.office.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.office.model.DepartmentModel;

/**
 * Created by zamzam on 2015/10/07.
 */
public class DepartmentForm extends FormLayout {
    private final DepartmentModel bean;
    public final BeanItem<DepartmentModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public DepartmentForm(){
        bean = new DepartmentModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField name = UIComponent.getTextField("Department Name :", "name", DepartmentModel.class, binder);
        TextField description = UIComponent.getTextField("Department Description :", "description", DepartmentModel.class, binder);
        TextField active = UIComponent.getTextField("Is Department Active :", "active", DepartmentModel.class, binder);
        DateField dateEstablished = UIComponent.getDateField("Department Name :", "dateEstablished", DepartmentModel.class, binder);

        addComponent(name);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
