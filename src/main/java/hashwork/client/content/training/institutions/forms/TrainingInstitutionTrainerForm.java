package hashwork.client.content.training.institutions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.training.institutions.model.TrainingInstitutionTrainerModel;

/**
 * Created by hashcode on 2015/10/10.
 */
public class TrainingInstitutionTrainerForm extends FormLayout {

    private final TrainingInstitutionTrainerModel bean;
    public final BeanItem<TrainingInstitutionTrainerModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TrainingInstitutionTrainerForm() {
        bean = new TrainingInstitutionTrainerModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();


        TextField title = UIComponent.getGridTextField("Title:", "title", TrainingInstitutionTrainerModel.class, binder);
        TextField firstName = UIComponent.getGridTextField("First Name :", "firstName", TrainingInstitutionTrainerModel.class, binder);

        TextField lastName = UIComponent.getGridTextField("Last Name :", "lastName", TrainingInstitutionTrainerModel.class, binder);

        TextField qualification = UIComponent.getGridTextField("Qualification :", "qualification", TrainingInstitutionTrainerModel.class, binder);

        addComponent(title);
        addComponent(firstName);
        addComponent(lastName);
        addComponent(qualification);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}

