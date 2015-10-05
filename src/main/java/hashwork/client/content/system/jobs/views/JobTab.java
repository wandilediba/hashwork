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
import hashwork.client.content.system.jobs.forms.JobForm;
import hashwork.client.content.system.jobs.model.JobModel;
import hashwork.client.content.system.jobs.table.JobTable;
import hashwork.domain.payroll.ui.job.Job;
import hashwork.factories.payroll.ui.Job.JobFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by hashcode on 2015/09/16.
 */
public class JobTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final JobForm form;
    private final JobTable table;

    public JobTab(MainLayout app) {
        main = app;
        form = new JobForm();
        table = new JobTable(main);
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
            final Job Job = JobFacade.jobService.findById(table.getValue().toString());
            final JobModel model = getModel(Job);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.jobService.save(getNewEntity(binder));
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
            JobFacade.jobService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Job Job = JobFacade.jobService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            JobFacade.jobService.delete(Job);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new JobsMenu(main, JobsTabValues.JOB.name()));
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

    private Job getNewEntity(FieldGroup binder) {
        final JobModel model = ((BeanItem<JobModel>) binder.getItemDataSource()).getBean();
        Map<String, String> values = new HashMap<>();
        values.put("title", model.getTitle());
        values.put("code", model.getCode());
        values.put("desc", model.getDescription());
        values.put("salaryGradeId", model.getSalaryGradeId());
        values.put("jobClassId", model.getJobClassificationId());
        final Job Job = JobFactory.getJob(values);
        return Job;
    }

    private Job getUpdateEntity(FieldGroup binder) {
        final JobModel model = ((BeanItem<JobModel>) binder.getItemDataSource()).getBean();
        final Job Job = JobFacade.jobService.findById(table.getValue().toString());
        final Job updatedJob = new Job
                .Builder().copy(Job)
                .jobClassificationId(model.getJobClassificationId())
                .code(model.getCode())
                .description(model.getDescription())
                .salaryGradeId(model.getSalaryGradeId())
                .title(model.getTitle())
                .build();
        return updatedJob;
    }

    private JobModel getModel(Job job) {
        final JobModel model = new JobModel();
        model.setCode(job.getCode());
        model.setDescription(job.getDescription());
        model.setJobClassificationId(job.getJobClassificationId());
        model.setSalaryGradeId(job.getSalaryGradeId());
        model.setTitle(job.getTitle());
        return model;
    }
}
