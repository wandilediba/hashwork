package hashwork.client.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.locations.model.LocationModel;


/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationForm extends FormLayout {
    private final LocationModel bean;
    public final BeanItem<LocationModel> item;
    public final FieldGroup binder;
    private final UIComponentHelper UIComponent = new UIComponentHelper();
    private final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();
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

        HorizontalLayout buttons = getButtons();
        buttons.setSizeFull();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//        private String name;
//        private String code;
//        private String latitude;
//        private String longitude;
//        private String locationTypeId;
//        private List<String> childrenIds; // Province has Cities as Children
//        private String parentId; //Location Id of Parent, e.g Country --> Province-->City


        ComboBox locationTypes = UIComboBox.getLocationTypeComboBox("Location Type :", "locationTypeId", LocationModel.class, binder);
        TextField name = UIComponent.getTextField("Location Name :", "name", LocationModel.class, binder);

        ComboBox parent = UIComboBox.getLocationComboBox("Parent Location :", "parentId", LocationModel.class, binder);
        TextField code = UIComponent.getTextField("Location  Code :", "code", LocationModel.class, binder);
        TextField latitude = UIComponent.getTextField("Latitude :", "latitude", LocationModel.class, binder);
        TextField longitude = UIComponent.getTextField("Longitude :", "longitude", LocationModel.class, binder);


        // Create a field group and use it to bind the fields in the layout


        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(parent, 0, 0);
        grid.addComponent(name, 1, 0);
        grid.addComponent(code, 2, 0);

        //Second ROW
        grid.addComponent(locationTypes, 0, 1);
        grid.addComponent(latitude, 1, 1);
        grid.addComponent(longitude, 2, 1);


        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);


        addComponent(grid);
        addComponent(buttons);


    }

    // Add the bean validator
    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        save.setSizeFull();
        edit.setSizeFull();
        cancel.setSizeFull();
        update.setSizeFull();
        delete.setSizeFull();

        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }
}
