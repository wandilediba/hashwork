package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseCompetencies;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/21.
 */
public class CourseCompetenciesForm extends FormLayout{
    private final CourseCompetencies bean;
    public final BeanItem<CourseCompetencies> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseCompetenciesForm(){
        bean = new CourseCompetencies();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox status = UIComboBox.getLocationTypeComboBox("Status :", "status", CourseCompetencies.class, binder);
        ComboBox courseStatusId = UIComboBox.getLocationTypeComboBox("Requestor Id :", "requestorId", CourseCompetencies.class, binder);

        addComponent(status);
        addComponent(courseStatusId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }

}
