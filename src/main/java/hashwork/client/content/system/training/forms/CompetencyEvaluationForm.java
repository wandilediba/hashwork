package hashwork.client.content.system.training.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.training.model.CompetencyEvaluation;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CompetencyEvaluationForm extends FormLayout {
    private final CompetencyEvaluation bean;
    public final BeanItem<CompetencyEvaluation> item;
    public final FieldGroup binder;

    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyEvaluationForm() {
        bean = new CompetencyEvaluation();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

    }
}
