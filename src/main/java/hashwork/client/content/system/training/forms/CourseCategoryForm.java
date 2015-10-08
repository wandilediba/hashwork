package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import hashwork.domain.ui.training.CourseCategory;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseCategoryForm extends FormLayout {

    private final CourseCategory bean;
    public final BeanItem<CourseCategory> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseCategoryForm() {
        bean = new CourseCategory();
        item = new BeanItem<CourseCategory>(bean);
        binder = new FieldGroup(item);

        TextField categoryName = new TextField("Course Category Name");
        categoryName.setNullRepresentation("");


        // Add the bean validator
        categoryName.addValidator(new BeanValidator(CourseCategory.class, "categoryName"));
        categoryName.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(categoryName, "categoryName");

        addComponent(categoryName);

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