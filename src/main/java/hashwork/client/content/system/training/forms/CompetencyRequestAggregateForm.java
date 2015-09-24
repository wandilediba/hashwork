package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CompetencyRequestAggregate;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/21.
 */
public class CompetencyRequestAggregateForm extends FormLayout{
    private final CompetencyRequestAggregate bean;
    public final BeanItem<CompetencyRequestAggregate> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyRequestAggregateForm(){
        bean = new CompetencyRequestAggregate();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField competencyName = UIComponent.getGridTextField("Competency Name :", "competencyName", CompetencyRequestAggregate.class, binder);
        DateField requestDate = UIComponent.getDateField("Request Date :", "requestDate", CompetencyRequestAggregate.class, binder);
        TextField requestorName = UIComponent.getGridTextField("Requestor Name :", "longitude", CompetencyRequestAggregate.class, binder);
        TextField rejectComment = UIComponent.getGridTextField("Reject Comment :", "rejectComment", CompetencyRequestAggregate.class, binder);

        ComboBox requestorId = UIComboBox.getLocationTypeComboBox("Requestor Id :", "requestorId", CompetencyRequestAggregate.class, binder);
        ComboBox status = UIComboBox.getLocationTypeComboBox("Status :", "status", CompetencyRequestAggregate.class, binder);
        ComboBox competencyId = UIComboBox.getLocationTypeComboBox("Competency Id :", "competencyId", CompetencyRequestAggregate.class, binder);

        addComponent(competencyName);
        addComponent(requestorName);
        addComponent(rejectComment);

        addComponent(requestorId);
        addComponent(status);
        addComponent(competencyId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }

}
