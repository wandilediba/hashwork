package hashwork.client.content.training.registration.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import hashwork.app.facade.LocationFacade;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingInstitutionForm extends FormLayout {

    private final TrainingInstitutionBean bean;
    public final BeanItem<TrainingInstitutionBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TrainingInstitutionForm() {
        bean = new TrainingInstitutionBean();
        item = new BeanItem<TrainingInstitutionBean>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);


        TextField trainingTrainingInstitutionName = getTextField("TrainingInstitution  Name", "trainingInstitution");
        TextField contactNumber = getTextField("Contact Number", "contactNumber");
        TextField emailAddress = getTextField("Email Address", "emailAddress");
        TextField postalCode = getTextField("Postal Code", "postalCode");
        TextArea postalAddress = getTextArea("Postal Address", "postalAddress");
        TextArea physicalAddress = getTextArea("Physical  Address", "physicalAddress");
        ComboBox city = getComboBox("City", "city");


        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();
        grid.addComponent(trainingTrainingInstitutionName, 0, 0);
        grid.addComponent(emailAddress, 1, 0);
        grid.addComponent(contactNumber, 2, 0);
        grid.addComponent(physicalAddress, 0, 1, 0, 2);
        grid.addComponent(postalAddress, 1, 1, 1, 2);
        grid.addComponent(postalCode, 2, 1);
        grid.addComponent(city, 2, 2);
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
    }

    private TextArea getTextArea(String label, String field) {
        TextArea textArea = new TextArea(label);
        textArea.setWidth(250, Unit.PIXELS);
        textArea.setNullRepresentation("");
        textArea.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
        textArea.setImmediate(true);
        binder.bind(textArea, field);
        return textArea;

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Location> locations = LocationFacade.getLocationModelService().findAll();

//        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
//        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);

        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location location : cities) {
            comboBox.addItem(location.getId());
            comboBox.setItemCaption(location.getId(), location.getName());
        }
        comboBox.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        return buttons;
    }
}