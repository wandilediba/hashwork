package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseFundingSource;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zenzile on 2015/09/21.
 */
public class CourseFundingSourceForm extends FormLayout{
    private final CourseFundingSource bean;
    public final BeanItem<CourseFundingSource> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CourseFundingSourceForm(){
        bean = new CourseFundingSource();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        TextField amount = UIComponent.getGridTextField("Amount :", "amount", CourseFundingSource.class, binder);

        //ComboBox Fields
        ComboBox courseId = UIComboBox.getLocationTypeComboBox("Course ID :", "courseId", CourseFundingSource.class, binder);
        ComboBox funderId = UIComboBox.getLocationComboBox("Funder ID :", "funderId", CourseFundingSource.class, binder);
        ComboBox currencyId = UIComboBox.getLocationComboBox("Currency ID :", "currencyId", CourseFundingSource.class, binder);

        addComponent(amount);
        addComponent(courseId);
        addComponent(funderId);
        addComponent(currencyId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);

    }
}
