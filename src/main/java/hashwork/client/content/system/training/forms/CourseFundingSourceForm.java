package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CourseFundingSource;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zenzile on 2015/09/19.
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
    }
}
