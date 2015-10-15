package hashwork.client.content.system.office.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.office.OfficeMenu;
import hashwork.client.content.system.office.forms.DepartmentForm;
import hashwork.client.content.system.office.model.DepartmentModel;
import hashwork.client.content.system.office.table.DepartmentTable;
import hashwork.domain.office.Department;
import hashwork.factories.office.DepartmentFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class DepartmentTab extends VerticalLayout
implements Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final DepartmentForm form;
    private final DepartmentTable table;

    public DepartmentTab(MainLayout app) {
        main = app;
        form = new DepartmentForm();
        table = new DepartmentTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final Department Department = OfficeFacade.departmentService.findById(table.getValue().toString());
            final DepartmentModel model = getModel(Department);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            OfficeFacade.departmentService.save(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            OfficeFacade.departmentService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Department Department = OfficeFacade.departmentService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            OfficeFacade.departmentService.delete(Department);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new OfficeMenu(main, "Department"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviour
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((Button.ClickListener) this);
        form.edit.addClickListener((Button.ClickListener) this);
        form.cancel.addClickListener((Button.ClickListener) this);
        form.update.addClickListener((Button.ClickListener) this);
        form.delete.addClickListener((Button.ClickListener) this);
        //Register Table Listeners
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }


    private Department getNewEntity(FieldGroup binder) {
        final DepartmentModel model = ((BeanItem<DepartmentModel>) binder.getItemDataSource()).getBean();
        final Department Department = DepartmentFactory.getDepartment(
                model.getName(),
                model.getDateEstablished(),
                model.isActive(),
                model.getDescription());
        return Department;
    }

    private Department getUpdateEntity(FieldGroup binder) {
        final DepartmentModel model = ((BeanItem<DepartmentModel>) binder.getItemDataSource()).getBean();
        final Department department = OfficeFacade.departmentService.findById(table.getValue().toString());
        final Department updatedDepartment = new Department
                .Builder().copy(department)
                .name(model.getName())
                .description(model.getDescription())
                .dateEstablished(model.getDateEstablished())
                .active(model.isActive())
                .build();
        return updatedDepartment;


    }

    private DepartmentModel getModel(Department department) {
        final DepartmentModel model = new DepartmentModel();
        model.setName(department.getName());
        model.setDescription(department.getDescription());
        model.setActive(department.isActive());
        model.setDateEstablished(department.getDateEstablished());

        return model;
    }
}
