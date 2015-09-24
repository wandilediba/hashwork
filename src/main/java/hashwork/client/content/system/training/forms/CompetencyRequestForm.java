package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CompetencyRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zenzile on 2015/09/21.
 */
public class CompetencyRequestForm extends FormLayout{
    private final CompetencyRequest bean;
    public final BeanItem<CompetencyRequest> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyRequestForm(){
        bean = new CompetencyRequest();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField competencyName = UIComponent.getGridTextField("Competency Name :", "competencyName", CompetencyRequest.class, binder);
        TextField count = UIComponent.getGridTextField("Count :", "count", CompetencyRequest.class, binder);
        ComboBox status = UIComboBox.getLocationTypeComboBox("Status :", "status", CompetencyRequest.class, binder);

        addComponent(competencyName);
        addComponent(count);
        addComponent(status);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }
}
