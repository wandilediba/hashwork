package hashwork.client.content.system.education.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.education.EducationMenu;
import hashwork.client.content.system.education.forms.EducationTypeForm;
import hashwork.client.content.system.education.model.EducationTypeModel;
import hashwork.client.content.system.education.table.EducationTypeTable;
import hashwork.domain.ui.education.EducationType;
import hashwork.factories.ui.education.EducationTypeFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class EducationTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final EducationTypeForm form;
    private final EducationTypeTable table;

    public EducationTypeTab(MainLayout app) {
        main = app;
        form = new EducationTypeForm();
        table = new EducationTypeTable(main);
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
            final EducationType EducationType = EducationFacade.educationTypeService.findById(table.getValue().toString());
            final EducationTypeModel model = getModel(EducationType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            EducationFacade.educationTypeService.save(getNewEntity(binder));
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
            EducationFacade.educationTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        EducationType educationType = EducationFacade.educationTypeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            EducationFacade.educationTypeService.delete(educationType);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new EducationMenu(main, "EducationType"));
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


    private EducationType getNewEntity(FieldGroup binder) {
        final EducationTypeModel model = ((BeanItem<EducationTypeModel>) binder.getItemDataSource()).getBean();
        final EducationType EducationType = EducationTypeFactory.getEducation(
                model.getName());
        return EducationType;
    }

    private EducationType getUpdateEntity(FieldGroup binder) {
        final EducationTypeModel model = ((BeanItem<EducationTypeModel>) binder.getItemDataSource()).getBean();
        final EducationType educationType = EducationFacade.educationTypeService.findById(table.getValue().toString());
        final EducationType updatedEducationType = new EducationType.Builder().copy(educationType).name(model.getName()).build();
        return updatedEducationType;
    }

    private EducationTypeModel getModel(EducationType educationType) {
        final EducationTypeModel model = new EducationTypeModel();
        model.setName(educationType.getName());
        return model;
    }
}
