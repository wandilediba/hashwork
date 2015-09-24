package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.CompetencyTypeModel;
//import hashwork.services.ui.education.Impl.CompetencyTypeServiceImpl;

/**
 * Created by sbm on 2015/09/23.
 */
public class CompetencyTypeForm extends FormLayout {

    private final CompetencyTypeForm bean;
    //private final CompetencyTypeService competencyTypeService = new CompetencyTypeServiceImpl();

    public final BeanItem<CompetencyTypeForm> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyTypeForm() {
        bean = new CompetencyTypeForm();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField name = UIComponent.getTextField("Name :", "name", CompetencyTypeModel.class, binder);
        //Combos
        ComboBox id = UIComboBox.getLocationComboBox("ID:", "id", CompetencyTypeModel.class, binder);

        addComponent(name);
        addComponent(id);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
