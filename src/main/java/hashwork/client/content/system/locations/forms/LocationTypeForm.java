package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
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
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField name = UIComponent.getTextField("Role Name :", "name", LocationTypeModel.class, binder);
        TextField code = UIComponent.getTextField("Description :", "code", LocationTypeModel.class, binder);
        addComponent(name);
        addComponent(code);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }

}
