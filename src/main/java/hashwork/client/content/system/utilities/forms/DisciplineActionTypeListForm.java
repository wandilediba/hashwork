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
import hashwork.client.content.system.utilities.model.DisciplineActionTypeListModel;

/**
 * Created by hashcode on 2015/10/12.
 */
public class DisciplineActionTypeListForm extends FormLayout {

    private final DisciplineActionTypeListModel bean;
    public final BeanItem<DisciplineActionTypeListModel> item;
    public final FieldGroup binder;
    final UIComponentHelper UIComponent;
    final UIComboBoxHelper UIComboBox;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public DisciplineActionTypeListForm() {
        bean = new DisciplineActionTypeListModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        UIComponent = new UIComponentHelper();
        UIComboBox = new UIComboBoxHelper();

        TextField accidentName = UIComponent.getGridTextField("Disciplinary Action Name :", "name", DisciplineActionTypeListModel.class, binder);
        TextField description = UIComponent.getGridTextField("Description:", "description", DisciplineActionTypeListModel.class, binder);

        addComponent(accidentName);
        addComponent(description);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}