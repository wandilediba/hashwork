package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseCategory;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CourseCategoryForm  extends FormLayout{
    private final CourseCategory bean;
    public final BeanItem<CourseCategory> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseCategoryForm(){
        bean = new CourseCategory();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
    }
}
