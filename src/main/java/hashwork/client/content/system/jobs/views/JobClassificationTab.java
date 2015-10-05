package hashwork.client.content.system.jobs.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.JobFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.jobs.JobsMenu;
import hashwork.client.content.system.jobs.JobsTabValues;
import hashwork.client.content.system.jobs.forms.JobClassificationForm;
import hashwork.client.content.system.jobs.model.JobClassificationModel;
import hashwork.client.content.system.jobs.table.JobClassificationTable;
import hashwork.domain.payroll.ui.job.JobClassification;
import hashwork.factories.payroll.ui.Job.JobClassificationFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by hashcode on 2015/09/16.
 */
public class JobClassificationTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final JobClassificationForm form;
    private final JobClassificationTable table;

    public JobClassificationTab(MainLayout app) {
        main = app;
        form = new JobClassificationForm();
        table = new JobClassificationTable(main);
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
            final JobClassification JobClassification = JobFacade.jobClassificationService.findById(table.getValue().toString());
            final JobClassificationModel model = getModel(JobClassification);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.jobClassificationService.save(getNewEntity(binder));
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
            JobFacade.jobClassificationService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        JobClassification JobClassification = JobFacade.jobClassificationService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            JobFacade.jobClassificationService.delete(JobClassification);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new JobsMenu(main, JobsTabValues.JOBCLASSIFICATION.name()));
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


    private JobClassification getNewEntity(FieldGroup binder) {
        final JobClassificationModel model = ((BeanItem<JobClassificationModel>) binder.getItemDataSource()).getBean();
        Map<String, String> values = new HashMap<>();
        values.put("currTitle", model.getCurrentTitle());
        values.put("oldTitle", model.getCurrentTitle());
        values.put("oldCode", model.getOldCode());
        values.put("currCode", model.getCurrentCode());
        values.put("codeConvo", model.getCodeConversion());
        values.put("comment", model.getComment());
        final JobClassification JobClassification = JobClassificationFactory.getJobClassification(values);
        return JobClassification;
    }


    private JobClassification getUpdateEntity(FieldGroup binder) {
        final JobClassificationModel model = ((BeanItem<JobClassificationModel>) binder.getItemDataSource()).getBean();
        final JobClassification jobClassification = JobFacade.jobClassificationService.findById(table.getValue().toString());
        final JobClassification updatedJobClassification = new JobClassification
                .Builder().copy(jobClassification)
                .codeConversion(model.getCodeConversion())
                .comment(model.getComment())
                .currentCode(model.getCurrentCode())
                .currentTitle(model.getCurrentTitle())
                .oldCode(model.getOldCode())
                .oldTitle(model.getOldTitle())
                .build();
        return updatedJobClassification;


    }

    private JobClassificationModel getModel(JobClassification jobClassification) {
        final JobClassificationModel model = new JobClassificationModel();
        model.setCodeConversion(jobClassification.getCodeConversion());
        model.setComment(jobClassification.getComment());
        model.setCurrentCode(jobClassification.getCurrentCode());
        model.setCurrentTitle(jobClassification.getCurrentTitle());
        model.setOldCode(jobClassification.getOldCode());
        model.setOldTitle(jobClassification.getOldTitle());

        return model;
    }
}
