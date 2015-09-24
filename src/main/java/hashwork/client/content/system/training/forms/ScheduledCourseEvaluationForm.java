package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.ScheduledCourseEvaluation;

/**
 * Created by Rosie on 2015/09/23.
 */
public class ScheduledCourseEvaluationForm extends FormLayout {
    private final ScheduledCourseEvaluation bean;
    public final BeanItem<ScheduledCourseEvaluation> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ScheduledCourseEvaluationForm() {
        bean = new ScheduledCourseEvaluation();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        ComboBox id = UIComboBox.getLocationTypeComboBox("Id :", "id", ScheduledCourseEvaluation.class, binder);

        TextField scheduledCourseId = UIComponent.getTextField("Scheduled Course Id :", "scheduledCourseId", ScheduledCourseEvaluation.class, binder);
        ComboBox rate = UIComboBox.getLocationTypeComboBox("Rating :", "rating", ScheduledCourseEvaluation.class, binder);
        TextArea comment = UIComponent.getTextArea("Comments: ", "comments", ScheduledCourseEvaluation.class, binder);

        addComponent(id);
        addComponent(scheduledCourseId);
        addComponent(rate);
        addComponent(comment);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
