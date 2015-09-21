package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.JobApplicantModel;

/**
 * Created by zamzam on 15/09/21.
 */
public class JobApplicantForm extends FormLayout {
    private final JobApplicantModel bean;
    public final BeanItem<JobApplicantModel> item;
    public final FieldGroup binder;

    final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public JobApplicantForm(){

        bean = new JobApplicantModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

     //   TextField applicantId = UIComponent.getTextField("Applicant :", "applicantId", JobApplicantModel.class, binder);
        //ComboBox Fields
        ComboBox applicantId = UIComboBox.getLocationTypeComboBox("Location Type :", "locationTypeId", JobApplicantModel.class, binder);
        addComponent(applicantId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
