package hashwork.client.content.system.demographics.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.demographics.model.RolesListModel;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RolesListForm extends FormLayout {

    private final RolesListModel bean;
    public final BeanItem<RolesListModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public RolesListForm() {
        bean = new RolesListModel();
        item = new BeanItem<RolesListModel>(bean);
        binder = new FieldGroup(item);

//         private String rolename;
//    private String description;

        TextField rolename = new TextField("Role Name");
        rolename.setNullRepresentation("");
        TextField description = new TextField("Description");
        description.setNullRepresentation("");

        // Add the bean validator
        rolename.addValidator(new BeanValidator(RolesListModel.class, "roleName"));
        rolename.setImmediate(true);
        description.addValidator(new BeanValidator(RolesListModel.class, "description"));
        description.setImmediate(true);

        // Create a field group and use it to bind the fields in the layout

        binder.bind(rolename, "roleName");
        binder.bind(description, "description");
        addComponent(rolename);
        addComponent(description);
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        // Determines which properties are shown, and in which order:
        edit.setVisible(false);
        update.setVisible(false);
        delete.setVisible(false);
        addComponent(buttons);
    }


}
