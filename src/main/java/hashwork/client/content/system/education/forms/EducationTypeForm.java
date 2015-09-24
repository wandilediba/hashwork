package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.EducationTypeModel;
import hashwork.client.content.system.locations.model.LocationTypeModel;
import hashwork.services.ui.education.EducationTypeService;
//import hashwork.services.ui.education.Impl.EducationTypeServiceImpl;

/**
 * Created by sbm on 2015/09/23.
 */
public class EducationTypeForm extends FormLayout {

    private final EducationTypeModel bean;
   // private final EducationTypeService locationTypeService = new EducationTypeServiceImpl();
    public final BeanItem<EducationTypeModel> item;
    public final FieldGroup binder;

    //Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public EducationTypeForm() {
        bean = new EducationTypeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField name = UIComponent.getTextField("Name :", "name", LocationTypeModel.class, binder);
        TextField id = UIComponent.getTextField("id :", "id", LocationTypeModel.class, binder);
        addComponent(name);
        addComponent(id);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }
}
