package hashwork.client.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.positions.model.DepartureReasonModel;


/**
 * Created by hashcode on 2015/09/16.
 */
public class DepartureReasonForm extends FormLayout {
    private final DepartureReasonModel bean;
    public final BeanItem<DepartureReasonModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

//    private String reasonName;
//    private String description;

    public DepartureReasonForm() {
        bean = new DepartureReasonModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField reasonName = UIComponent.getTextField("Departure Reason :", "reasonName", DepartureReasonModel.class, binder);
        addComponent(reasonName);
        TextField description = UIComponent.getTextField("Description :", "description", DepartureReasonModel.class, binder);
        addComponent(description);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
