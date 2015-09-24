package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseRequest;

/**
 * Created by Rosie on 2015/09/24.
 */
public class CourseRequestForm extends FormLayout {

    private final CourseRequestForm bean;
    public final BeanItem<CourseRequestForm> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");


    public CourseRequestForm() {
        bean = new CourseRequestForm();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", CourseRequestForm.class, binder);
        ComboBox requestorsid = UIComboBox.getLocationTypeComboBox("Requestors Id :", "requestorsIds", CourseRequestForm.class, binder);
        ComboBox compid = UIComboBox.getLocationTypeComboBox("Competencies Id :", "competenciesIds", CourseRequestForm.class, binder);
        ComboBox funderid = UIComboBox.getLocationTypeComboBox("Funders Id :", "funderIds", CourseRequestForm.class, binder);
        ComboBox trainid = UIComboBox.getLocationTypeComboBox("Training Institutions Id :", "trainingInstitutionsId", CourseRequestForm.class, binder);

        TextField stat = UIComponent.getTextField("Status :", "status", CourseRequestForm.class, binder);
        TextField name = UIComponent.getTextField("Request Name :", "requestName", CourseRequestForm.class, binder);

        DateField prefstat = UIComponent.getDateField("Preffered Start Date: ", "prefferedStart", CourseRequest.class, binder);
        DateField prefend = UIComponent.getDateField("Preffered End Date: ", "preferredEnd", CourseRequest.class,binder);
        DateField reqdate = UIComponent.getDateField("Requested Date: ", "requestedDate", CourseRequest.class,binder);

        addComponent(id);
        addComponent(requestorsid);
        addComponent(name);
        addComponent(trainid);
        addComponent(prefstat);
        addComponent(prefend);
        addComponent(reqdate);
        addComponent(compid);
        addComponent(funderid);
        addComponent(stat);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
