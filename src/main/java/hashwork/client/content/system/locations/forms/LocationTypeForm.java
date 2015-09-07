package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.locations.model.LocationTypeModel;
import hashwork.services.ui.location.Impl.LocationTypeServiceImpl;
import hashwork.services.ui.location.LocationTypeService;

/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationTypeForm extends FormLayout {
    private final LocationTypeModel bean;
    private final LocationTypeService locationTypeService = new LocationTypeServiceImpl();

    public final BeanItem<LocationTypeModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public LocationTypeForm() {
        bean = new LocationTypeModel();
        item = new BeanItem<LocationTypeModel>(bean);
        binder = new FieldGroup(item);

        TextField name = new TextField("Name");
        name.setNullRepresentation("");
        TextField code = new TextField("Code");
        code.setNullRepresentation("");

        // Add the bean validator
        name.addValidator(new BeanValidator(LocationTypeModel.class, "name"));
        name.setImmediate(true);
        code.addValidator(new BeanValidator(LocationTypeModel.class, "code"));
        code.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(name, "name");
        binder.bind(code, "code");

        addComponent(name);
        addComponent(code);
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
