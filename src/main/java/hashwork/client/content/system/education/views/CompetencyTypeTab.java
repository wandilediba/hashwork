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
import hashwork.client.content.system.education.forms.CompetencyTypeForm;
import hashwork.client.content.system.education.model.CompetencyTypeModel;
import hashwork.client.content.system.education.table.CompetencyTypeTable;
import hashwork.domain.ui.education.CompetencyType;
import hashwork.factories.ui.education.CompetencyTypeFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class CompetencyTypeTab extends VerticalLayout
implements Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final CompetencyTypeForm form;
    private final CompetencyTypeTable table;

    public CompetencyTypeTab(MainLayout app) {
        main = app;
        form = new CompetencyTypeForm();
        table = new CompetencyTypeTable(main);
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
            final CompetencyType CompetencyType = EducationFacade.competencyTypeService.findById(table.getValue().toString());
            final CompetencyTypeModel model = getModel(CompetencyType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            EducationFacade.competencyTypeService.save(getNewEntity(binder));
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
            EducationFacade.competencyTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CompetencyType CompetencyType = EducationFacade.competencyTypeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            EducationFacade.competencyTypeService.delete(CompetencyType);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new EducationMenu(main, "CompetencyType"));
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


    private CompetencyType getNewEntity(FieldGroup binder) {
        final CompetencyTypeModel model = ((BeanItem<CompetencyTypeModel>) binder.getItemDataSource()).getBean();
        final CompetencyType CompetencyType = CompetencyTypeFactory.getCompetencyType(
                model.getName());
        return CompetencyType;
    }

    private CompetencyType getUpdateEntity(FieldGroup binder) {
        final CompetencyTypeModel model = ((BeanItem<CompetencyTypeModel>) binder.getItemDataSource()).getBean();
        final CompetencyType CompetencyType = EducationFacade.competencyTypeService.findById(table.getValue().toString());
        final CompetencyType updatedCompetencyType = new CompetencyType
                .Builder().copy(CompetencyType)
                .name(model.getName())
                .build();
        return updatedCompetencyType;


    }

    private CompetencyTypeModel getModel(CompetencyType CompetencyType) {
        final CompetencyTypeModel model = new CompetencyTypeModel();
        model.setName(CompetencyType.getName());
        return model;
    }
}
