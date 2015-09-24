package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.ContinuingEducationCourse;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/21
 */
public class ContinuingEducationCourseForm extends FormLayout{
    private final ContinuingEducationCourse bean;
    public final BeanItem<ContinuingEducationCourse> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ContinuingEducationCourseForm(){
        bean = new ContinuingEducationCourse();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField courseName = UIComponent.getTextField("Course Name :", "name", ContinuingEducationCourse.class, binder);
        TextField creditHours = UIComponent.getTextField("Credit Hours :", "code", ContinuingEducationCourse.class, binder);

        addComponent(courseName);
        addComponent(creditHours);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
