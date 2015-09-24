package hashwork.client.content.system.jobs.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.JobFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.jobs.model.JobModel;
import hashwork.domain.payroll.ui.job.JobClassification;
import hashwork.domain.payroll.ui.job.SalaryGrade;

import java.util.Set;
import java.util.function.Consumer;


/**
 * Created by hashcode on 2015/09/16.
 */
public class JobForm extends FormLayout {
    private final JobModel bean;
    public final BeanItem<JobModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public JobForm() {
        bean = new JobModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        // Define Fields
        // Text Fields
        TextField title = UIComponent.getGridTextField("Job Title :", "title", JobModel.class, binder);
        TextField code = UIComponent.getGridTextField("Job Code :", "code", JobModel.class, binder);
        TextArea description = UIComponent.getGridTextArea("Job Description :", "description", JobModel.class, binder);


        //ComboBox Fields
        final ComboBox salaryGradeId = UIComboBox.getComboBox("Salary Grade :", "salaryGradeId", JobModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<SalaryGrade> salaryGrades = JobFacade.salaryGradeService.findAll();
                for (SalaryGrade salaryGrade : salaryGrades) {
                    comboBox.addItem(salaryGrade.getId());
                    comboBox.setItemCaption(salaryGrade.getId(), salaryGrade.getGradeName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox jobClassificationId = UIComboBox.getComboBox("Job Classification :", "jobClassificationId", JobModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<JobClassification> jobClassifications = JobFacade.jobClassificationService.findAll();
                for (JobClassification jobClassification : jobClassifications) {
                    comboBox.addItem(jobClassification.getId());
                    comboBox.setItemCaption(jobClassification.getId(), jobClassification.getCurrentTitle());
                }
            }
        });


        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(title, 0, 0);
        grid.addComponent(code, 0, 1);
        grid.addComponent(salaryGradeId, 2, 0);

        //Second ROW
        grid.addComponent(description, 1, 1);
        grid.addComponent(jobClassificationId, 2, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
