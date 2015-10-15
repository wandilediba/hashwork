package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseCategoryModel;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseCategoryForm extends FormLayout {

    private final CourseCategoryModel bean;
    public final BeanItem<CourseCategoryModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseCategoryForm() {
        bean = new CourseCategoryModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField gender = UIComponent.getTextField("Course Category Name :", "categoryName", CourseCategoryModel.class, binder);
        addComponent(gender);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}