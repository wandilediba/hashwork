package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.*;
import hashwork.app.facade.LocationFacade;
import hashwork.client.content.system.locations.model.LocationModel;
import hashwork.domain.ui.location.LocationType;

import java.util.Set;


/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationForm extends FormLayout {
    private final LocationModel bean;
    public final BeanItem<LocationModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public LocationForm() {
        bean = new LocationModel();
        item = new BeanItem<LocationModel>(bean);
        binder = new FieldGroup(item);

        TextField name = new TextField("Name");
        name.setNullRepresentation("");
        TextField code = new TextField("Code");
        code.setNullRepresentation("");
        TextField latitude = new TextField("Latitude");
        latitude.setNullRepresentation("");
        TextField longitude = new TextField("Longitude");
        longitude.setNullRepresentation("");
        Set<LocationType> locationTypes = LocationFacade.locationTypeService.findAll();

        ComboBox locationType = new ComboBox("Location Type:");
        for (LocationType lt : locationTypes) {
            locationType.addItem(lt.getId());
            locationType.setItemCaption(lt.getId(), lt.getName());
        }



        // Add the bean validator
        name.addValidator(new BeanValidator(LocationModel.class, "name"));
        name.setImmediate(true);
        code.addValidator(new BeanValidator(LocationModel.class, "code"));
        code.setImmediate(true);
        latitude.addValidator(new BeanValidator(LocationModel.class, "latitude"));
        latitude.setImmediate(true);
        longitude.addValidator(new BeanValidator(LocationModel.class, "longitude"));
        longitude.setImmediate(true);
        locationType.addValidator(new BeanValidator(LocationModel.class, "locationTypeId"));
        locationType.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(name, "name");
        addComponent(name);
        binder.bind(code, "code");
        addComponent(code);
        binder.bind(latitude, "latitude");
        addComponent(latitude);
        binder.bind(longitude, "longitude");
        addComponent(longitude);
        binder.bind(locationType, "locationTypeId");
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
