package hashwork.client.content.system.utilities.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.utilities.model.AccidentTypeListModel;

/**
 * Created by hashcode on 2015/10/12.
 */
public class AccidentTypeListForm extends FormLayout {

    private final AccidentTypeListModel bean;
    public final BeanItem<AccidentTypeListModel> item;
    public final FieldGroup binder;
    final UIComponentHelper UIComponent;
    final UIComboBoxHelper UIComboBox;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public AccidentTypeListForm() {
        bean = new AccidentTypeListModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        UIComponent = new UIComponentHelper();
        UIComboBox = new UIComboBoxHelper();


        TextField name = UIComponent.getGridTextField("Accident Type Name :", "name", AccidentTypeListModel.class, binder);
        TextField description = UIComponent.getGridTextField("Accident Type Description:", "description", AccidentTypeListModel.class, binder);

        addComponent(name);
        addComponent(description);
        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }
}
