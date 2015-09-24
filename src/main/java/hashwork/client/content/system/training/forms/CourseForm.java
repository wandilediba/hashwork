package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.Course;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zenzile on 2015/09/21.
 */
public class CourseForm extends FormLayout{
    private final Course bean;
    public final BeanItem<Course> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseForm() {
        bean = new Course();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField courseName = UIComponent.getTextField("Course Name :", "courseName", Course.class, binder);
        TextField courseTopic = UIComponent.getTextField("Course Topic :", "code", Course.class, binder);
        TextField courseObjective = UIComponent.getTextField("Course Objective :", "courseObjective", Course.class, binder);
        TextField creditHours = UIComponent.getTextField("Credit Hours :", "creditHours", Course.class, binder);

        ComboBox courseCategoryId = UIComboBox.getLocationTypeComboBox("Requestor Id :", "requestorId", Course.class, binder);
        ComboBox status = UIComboBox.getLocationTypeComboBox("Status :", "status", Course.class, binder);
        ComboBox courseStatusId = UIComboBox.getLocationTypeComboBox("Requestor Id :", "requestorId", Course.class, binder);

        addComponent(courseName);
        addComponent(courseTopic);
        addComponent(courseObjective);
        addComponent(creditHours);

        addComponent(courseCategoryId);
        addComponent(status);
        addComponent(courseStatusId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}

