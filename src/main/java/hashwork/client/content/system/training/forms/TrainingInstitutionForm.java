package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.TrainingInstitution;

/**
 * Created by Rosie on 2015/09/23.
 */
public class TrainingInstitutionForm extends FormLayout {

    private final TrainingInstitution bean;
    public final BeanItem<TrainingInstitution> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TrainingInstitutionForm() {
        bean = new TrainingInstitution();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", TrainingInstitution.class, binder);

        TextField institution = UIComponent.getTextField("Training Institution :", "trainingInstitution", TrainingInstitution.class, binder);
        TextField contact = UIComponent.getTextField("Location Contact :", "locationContact", TrainingInstitution.class, binder);
        TextField cityId = UIComponent.getTextField("City :", "cityId", TrainingInstitution.class, binder);


        addComponent(id);
        addComponent(institution);
        addComponent(contact);
        addComponent(cityId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
