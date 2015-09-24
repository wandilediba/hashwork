package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.EvaluationModel;
import hashwork.client.content.system.locations.model.LocationModel;
import hashwork.client.content.system.locations.model.LocationTypeModel;
import hashwork.domain.ui.education.Evaluation;
import hashwork.services.ui.education.EvaluationService;
//import hashwork.services.ui.education.Impl.EvaluationServiceImpl;

/**
 * Created by sbm on 2015/09/23.
 */
public class EvaluationForm  extends FormLayout {

    private final EvaluationModel bean;
    //private final EvaluationService locationTypeService = new EvaluationServiceImpl();

    public final BeanItem<EvaluationModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public EvaluationForm() {
        bean = new EvaluationModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField name = UIComponent.getTextField("Role Name :", "name", LocationTypeModel.class, binder);

        //Combo boxes
        ComboBox id = UIComboBox.getLocationComboBox("ID:", "id", EvaluationModel.class, binder);
        addComponent(name);
        addComponent(id);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }

}
