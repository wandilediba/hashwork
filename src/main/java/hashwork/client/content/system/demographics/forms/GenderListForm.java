package hashwork.client.content.system.demographics.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.demographics.model.GenderListModel;

/**
 * Created by hashcode on 2015/08/18.
 */
public class GenderListForm extends FormLayout {

    private final GenderListModel bean;
    public final BeanItem<GenderListModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public GenderListForm() {
        bean = new GenderListModel();
        item = new BeanItem<GenderListModel>(bean);
        binder = new FieldGroup(item);

        TextField gender = new TextField("Gender");
        gender.setNullRepresentation("");


        // Add the bean validator
        gender.addValidator(new BeanValidator(GenderListModel.class, "gender"));
        gender.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(gender, "gender");
        addComponent(gender);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        // Determines which properties are shown, and in which order:
        edit.setVisible(false);
        update.setVisible(false);
        delete.setVisible(false);
        addComponent(buttons);
    }
}
