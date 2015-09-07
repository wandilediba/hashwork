package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.locations.model.AddressTypeModel;


/**
 * Created by hashcode on 2015/09/07.
 */
public class AddressTypeForm extends FormLayout {
    private final AddressTypeModel bean;
    public final BeanItem<AddressTypeModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public AddressTypeForm() {
        bean = new AddressTypeModel();
        item = new BeanItem<AddressTypeModel>(bean);
        binder = new FieldGroup(item);

        TextField addressTypeName = new TextField("Address Type Name");
        addressTypeName.setNullRepresentation("");


        // Add the bean validator
        addressTypeName.addValidator(new BeanValidator(AddressTypeModel.class, "addressTypeName"));
        addressTypeName.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(addressTypeName, "addressTypeName");
        addComponent(addressTypeName);

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
