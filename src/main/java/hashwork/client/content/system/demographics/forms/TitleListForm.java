package hashwork.client.content.system.demographics.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.demographics.model.TitleListModel;

/**
 * Created by hashcode on 2015/08/18.
 */
public class TitleListForm extends FormLayout {


    private final TitleListModel bean;
    public final BeanItem<TitleListModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TitleListForm() {
        bean = new TitleListModel();
        item = new BeanItem<TitleListModel>(bean);
        binder = new FieldGroup(item);

        TextField title = new TextField("Title");
        title.setNullRepresentation("");


        // Add the bean validator
        title.addValidator(new BeanValidator(TitleListModel.class, "title"));
        title.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(title, "title");
        addComponent(title);
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
