package hashwork.client.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.positions.model.PositionModel;
import hashwork.domain.office.Department;
import hashwork.domain.office.Office;
import hashwork.domain.payroll.ui.job.Job;
import hashwork.domain.people.Person;
import hashwork.domain.ui.position.Position;
import hashwork.domain.ui.position.PositionType;
import hashwork.domain.ui.util.Status;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionForm extends FormLayout {
    private final PositionModel bean;
    public final BeanItem<PositionModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public PositionForm() {
        bean = new PositionModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        // Define Fields
        // Text Fields
        TextField positionTitle = UIComponent.getGridTextField("Position Title :", "positionTitle", PositionModel.class, binder);
        TextField positionCode = UIComponent.getGridTextField("Position Code :", "positionCode", PositionModel.class, binder);

        DateField postionEntryDate = UIComponent.getGridDateField("Entry Date :", "postionEntryDate", PositionModel.class, binder);
        DateField positionEndDate = UIComponent.getGridDateField("End Date :", "positionEndDate", PositionModel.class, binder);

        TextArea description = UIComponent.getGridTextArea("Position Description :", "description", PositionModel.class, binder);
        TextArea positionComments = UIComponent.getGridTextArea("Position Comments :", "positionComments", PositionModel.class, binder);


        //ComboBox Fields
        final ComboBox currentOccupantId = UIComboBox.getComboBox("Current Occupant :", "currentOccupantId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Person> employees = PeopleFacade.personService.findAll();
                for (Person employee : employees) {
                    comboBox.addItem(employee.getId());
                    comboBox.setItemCaption(employee.getId(), employee.getLastName() + " " + employee.getFirstName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox positionTypeId = UIComboBox.getComboBox("Position Type :", "positionTypeId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<PositionType> positionTypes = PositionFacade.positionTypeService.findAll();
                for (PositionType positionType : positionTypes) {
                    comboBox.addItem(positionType.getId());
                    comboBox.setItemCaption(positionType.getId(), positionType.getName());
                }
            }
        });


        //ComboBox Fields
        final ComboBox positionStatusId = UIComboBox.getComboBox("Postion Status :", "positionStatusId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Status> statuses = UtilFacade.statusService.findAll();
                for (Status status : statuses) {
                    comboBox.addItem(status.getId());
                    comboBox.setItemCaption(status.getId(), status.getStatusValues());
                }
            }
        });

        //ComboBox Fields
        final ComboBox officeId = UIComboBox.getComboBox("Office :", "officeId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Office> offices = OfficeFacade.officeService.findAll();
                for (Office office : offices) {
                    comboBox.addItem(office.getId());
                    comboBox.setItemCaption(office.getId(), office.getName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox supervisorId = UIComboBox.getComboBox("Position Supervisor :", "supervisorId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Position> positions = PositionFacade.positionService.findAll();
                for (Position position : positions) {
                    comboBox.addItem(position.getId());
                    comboBox.setItemCaption(position.getId(), position.getPositionTitle());
                }
            }
        });

        //ComboBox Fields
        final ComboBox departmentId = UIComboBox.getComboBox("Department :", "departmentId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Department> departments = OfficeFacade.departmentService.findAll();
                for (Department department : departments) {
                    comboBox.addItem(department.getId());
                    comboBox.setItemCaption(department.getId(), department.getName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox jobId = UIComboBox.getComboBox("Job Title :", "jobId", PositionModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Job> jobs = JobFacade.jobService.findAll();
                for (Job job : jobs) {
                    comboBox.addItem(job.getId());
                    comboBox.setItemCaption(job.getId(), job.getTitle());
                }
            }
        });


        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(positionTitle, 0, 0);
        grid.addComponent(positionCode, 1, 0);
        grid.addComponent(postionEntryDate, 2, 0);

        //Second ROW
        grid.addComponent(description, 0, 1);
        grid.addComponent(positionEndDate, 1, 1);
        grid.addComponent(positionComments, 2, 1);

        // Third ROW
        grid.addComponent(currentOccupantId, 0, 2);
        grid.addComponent(positionTypeId, 1, 2);
        grid.addComponent(positionStatusId, 2, 2);

        //Fourth ROW
        grid.addComponent(officeId, 0, 3);
        grid.addComponent(supervisorId, 1, 3);
        grid.addComponent(departmentId, 2, 3);

        // 6th ROW
        grid.addComponent(jobId, 0, 4);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 5, 2, 5);
        grid.addComponent(buttons, 0, 6, 2, 6);

        addComponent(grid);
    }
}
