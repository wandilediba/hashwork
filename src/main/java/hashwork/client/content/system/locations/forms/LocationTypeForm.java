package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.*;
import hashwork.client.content.system.locations.model.LocationTypeModel;
import hashwork.domain.ui.location.LocationType;

import java.util.List;

/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationTypeForm extends FormLayout {
    private final LocationTypeModel bean;

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
        TextField latitude = new TextField("Latitude");
        latitude.setNullRepresentation("");
        TextField longitude = new TextField("Longitude");
        longitude.setNullRepresentation("");
        List<LocationType> locationTypes = LocationFacade.getLocationTypeModelService().findAll();

        ComboBox locationType = new ComboBox("Location Type:");
        for (LocationType lt : locationTypes) {
            locationType.addItem(lt.getId());
            locationType.setItemCaption(lt.getId(), lt.getName());
        }

        // Add the bean validator
        name.addValidator(new BeanValidator(LocationTypeModel.class, "name"));
        name.setImmediate(true);
        code.addValidator(new BeanValidator(LocationTypeModel.class, "code"));
        code.setImmediate(true);
        latitude.addValidator(new BeanValidator(LocationTypeModel.class, "latitude"));
        latitude.setImmediate(true);
        longitude.addValidator(new BeanValidator(LocationTypeModel.class, "longitude"));
        longitude.setImmediate(true);
        locationType.addValidator(new BeanValidator(LocationTypeModel.class, "locationType"));
        locationType.setImmediate(true);

        // Create a field group and use it to bind the fields in the layout

        binder.bind(name, "name");
        binder.bind(code, "code");
        binder.bind(latitude, "latitude");
        binder.bind(longitude, "longitude");
        binder.bind(locationType, "locationType");
        addComponent(name);
        addComponent(code);
        addComponent(latitude);
        addComponent(longitude);
        addComponent(locationType);
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
