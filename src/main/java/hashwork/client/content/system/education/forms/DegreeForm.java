package hashwork.client.content.system.education.forms;


import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.DegreeModel;

/**
 * Created by sbm on 2015/09/24.
 */
public class DegreeForm extends FormLayout{

    private final DegreeModel bean;
    // private final EducationTypeService locationTypeService = new EducationTypeServiceImpl();
    public final BeanItem<DegreeModel> item;
    public final FieldGroup binder;

    //Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public DegreeForm() {
        bean = new DegreeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField name = UIComponent.getTextField("Name :", "name", DegreeModel.class, binder);
        TextField id = UIComponent.getTextField("ID :", "id", DegreeModel.class, binder);
        addComponent(name);
        addComponent(id);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }
}
