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
import hashwork.client.content.system.education.forms.DegreeForm;
import hashwork.client.content.system.education.model.DegreeModel;
import hashwork.client.content.system.education.table.DegreeTable;
import hashwork.domain.ui.education.Degree;
import hashwork.factories.ui.education.DegreeFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class DegreeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final DegreeForm form;
    private final DegreeTable table;

    public DegreeTab(MainLayout app) {
        main = app;
        form = new DegreeForm();
        table = new DegreeTable(main);
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
            final Degree Degree = EducationFacade.degreeService.findById(table.getValue().toString());
            final DegreeModel model = getModel(Degree);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            EducationFacade.degreeService.save(getNewEntity(binder));
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
            EducationFacade.degreeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Degree Degree = EducationFacade.degreeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            EducationFacade.degreeService.delete(Degree);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new EducationMenu(main, "Degree"));
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


    private Degree getNewEntity(FieldGroup binder) {
        final DegreeModel model = ((BeanItem<DegreeModel>) binder.getItemDataSource()).getBean();
        final Degree Degree = DegreeFactory.getDegree(
                model.getStudyField(),
                model.getEducationTypeId(),
                model.getDegreeName());
        return Degree;
    }

    private Degree getUpdateEntity(FieldGroup binder) {
        final DegreeModel model = ((BeanItem<DegreeModel>) binder.getItemDataSource()).getBean();
        final Degree Degree = EducationFacade.degreeService.findById(table.getValue().toString());
        final Degree updatedDegree = new Degree
                .Builder().copy(Degree)
                .studyField(model.getStudyField())
                .educationTypeId(model.getEducationTypeId())
                .degreeName(model.getDegreeName())
                .build();
        return updatedDegree;


    }

    private DegreeModel getModel(Degree degree) {
        final DegreeModel model = new DegreeModel();
        model.setStudyField(degree.getStudyField());
        model.setEducationTypeId(degree.getEducationTypeId());
        model.setDegreeName(degree.getDegreeName());
        return model;
    }
}
