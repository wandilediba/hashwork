package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.TrainingInstitution;
import hashwork.client.content.system.training.model.TrainingInstitutionTrainer;

/**
 * Created by Rosie on 2015/09/23.
 */
public class TrainingInstitutionTrainerForm extends FormLayout{

    private final TrainingInstitutionTrainer bean;
    public final BeanItem<TrainingInstitutionTrainer> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TrainingInstitutionTrainerForm() {
        bean = new TrainingInstitutionTrainer();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", TrainingInstitutionTrainer.class, binder);

        TextField name = UIComponent.getTextField("Course Capacity :", "courseCapacity", TrainingInstitutionTrainer.class, binder);
        TextField fname = UIComponent.getTextField("First Name :", "firstname", TrainingInstitutionTrainer.class, binder);
        TextField sname = UIComponent.getTextField("Surname :", "lastname", TrainingInstitutionTrainer.class, binder);
        TextField qual = UIComponent.getTextField("Qualification :", "qualification", TrainingInstitutionTrainer.class, binder);

        addComponent(id);
        addComponent(name);
        addComponent(fname);
        addComponent(sname);
        addComponent(qual);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
