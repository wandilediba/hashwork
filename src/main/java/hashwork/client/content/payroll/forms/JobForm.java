package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.JobModel;

/**
 * Created by zamzam on 15/09/22.
 */
public class JobForm extends FormLayout {
    private final JobModel bean;
    public final BeanItem<JobModel> item;
    public final FieldGroup binder;

    // Define Public Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public JobForm(){
        bean = new JobModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        // Define Fields
        // Text Fields
        TextField title = UIComponent.getGridTextField("Job Title :", "title", JobModel.class, binder);
        TextField code = UIComponent.getGridTextField("Job Code :", "code", JobModel.class, binder);
        TextField description = UIComponent.getGridTextField("Job Description :", "description", JobModel.class, binder);
      //  TextField salaryGrade = UIComponent.getGridTextField("Longitude :", "longitude", JobModel.class, binder);

//        //ComboBox Fields
//        ComboBox salaryGrade = UIComboBox.getComboBox("Salary Grade :", "salaryGrade", JobModel.class, binder);
//        ComboBox jobClassificationId = UIComboBox.getComboBox("Job Classification :", "jobClassificationId", JobModel.class, binder);
//        ComboBox position = UIComboBox.getLocationComboBox("Job Position :", "position", JobModel.class, binder);






        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(title, 0, 0);
        grid.addComponent(code, 1, 0);
        grid.addComponent(description, 2, 0);

//        //Second ROW
//        grid.addComponent(salaryGrade, 0, 1);
//        grid.addComponent(jobClassificationId, 1, 1);
//        grid.addComponent(position, 2, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
