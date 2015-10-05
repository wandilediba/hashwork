package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.JobClassificationModel;

/**
 * Created by zamzam on 15/09/22.
 */
public class JobClassificationForm extends FormLayout {
    private final JobClassificationModel bean;
    public final BeanItem<JobClassificationModel> item;
    public final FieldGroup binder;

    // Define Public Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public JobClassificationForm(){
        bean = new JobClassificationModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField currentTitle = UIComponent.getTextField("Current Title :", "addressTypeName", JobClassificationModel.class, binder);
        TextField oldTitle = UIComponent.getTextField("Old Title :", "oldTitle", JobClassificationModel.class, binder);
        TextField oldCode = UIComponent.getTextField("Old Code :", "oldCode", JobClassificationModel.class, binder);
        TextField currentCode = UIComponent.getTextField("Current Code :", "currentCode", JobClassificationModel.class, binder);
        TextField codeConversion = UIComponent.getTextField("Code Conversion :", "codeConversion", JobClassificationModel.class, binder);
        TextField comment = UIComponent.getTextField("Comment :", "comment", JobClassificationModel.class, binder);

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(currentTitle, 0, 0);
        grid.addComponent(currentCode, 1, 0);
        grid.addComponent(codeConversion, 2, 0);

        //Second ROW
        grid.addComponent(oldTitle, 0, 1);
        grid.addComponent(oldCode, 1, 1);
        grid.addComponent(comment, 2, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
