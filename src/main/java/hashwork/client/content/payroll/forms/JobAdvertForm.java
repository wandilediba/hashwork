package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.JobAdvertModel;

/**
 * Created by zamzam on 15/09/22.
 */
public class JobAdvertForm extends FormLayout {
    private final JobAdvertModel bean;
    public final BeanItem<JobAdvertModel> item;
    public final FieldGroup binder;

    // Define Public Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public JobAdvertForm(){
        bean = new JobAdvertModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        // Define Fields
        // Text Fields
        DateField start = UIComponent.getDateField("Job Advert Start Date :", "name", JobAdvertModel.class, binder);
        DateField closingDate = UIComponent.getDateField("Job Advert closing Date :", "code", JobAdvertModel.class, binder);
        TextField description = UIComponent.getGridTextField("Job Advert Description :", "latitude", JobAdvertModel.class, binder);
        TextField active = UIComponent.getGridTextField("Longitude :", "longitude", JobAdvertModel.class, binder);

        //ComboBox Fields
        ComboBox jobId = UIComboBox.getLocationTypeComboBox("Job Type :", "jobId", JobAdvertModel.class, binder);
        ComboBox applicants = UIComboBox.getLocationComboBox("Applicants Type :", "applicantsIds", JobAdvertModel.class, binder);

        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(jobId, 0, 0);
        grid.addComponent(start, 1, 0);
        grid.addComponent(closingDate, 2, 0);

        //Second ROW
        grid.addComponent(applicants, 0, 1);
        grid.addComponent(description, 1, 1);
        grid.addComponent(active, 2, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);

    }
}
