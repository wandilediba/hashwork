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
import hashwork.client.content.system.jobs.forms.SalaryGradeForm;
import hashwork.client.content.system.jobs.model.SalaryGradeModel;
import hashwork.client.content.system.jobs.table.SalaryGradeTable;
import hashwork.domain.payroll.ui.job.SalaryGrade;
import hashwork.factories.payroll.ui.Job.SalaryGradeFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hashcode on 2015/09/16.
 */
public class SalaryGradeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final SalaryGradeForm form;
    private final SalaryGradeTable table;

    public SalaryGradeTab(MainLayout app) {
        main = app;
        form = new SalaryGradeForm();
        table = new SalaryGradeTable(main);
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
            final SalaryGrade SalaryGrade = JobFacade.salaryGradeService.findById(table.getValue().toString());
            final SalaryGradeModel model = getModel(SalaryGrade);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.salaryGradeService.save(getNewEntity(binder));
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
            JobFacade.salaryGradeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        SalaryGrade SalaryGrade = JobFacade.salaryGradeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            JobFacade.salaryGradeService.delete(SalaryGrade);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new JobsMenu(main, "SalaryGrade"));
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

//    gradeName(values.get("gradeName"))
//            .notes(values.get("notes"))
//            .midAmount(amounts.get("midAmt"))
//            .endAmount(amounts.get("endAmt"))
//            .startAmount(amounts.get("startAmt"))
//            .currentAmount(amounts.get("currAmt"))
//            .currencyId(values.get("currId")

    private SalaryGrade getNewEntity(FieldGroup binder) {
        final SalaryGradeModel model = ((BeanItem<SalaryGradeModel>) binder.getItemDataSource()).getBean();
        final Map<String, String> values = new HashMap<>();
        values.put("gradeName", model.getGradeName());
        values.put("notes", model.getNotes());
        values.put("currId", model.getCurrencyId());
        final Map<String, BigDecimal> amounts = new HashMap<>();
        amounts.put("midAmt", model.getMidAmount());
        amounts.put("startAmt", model.getStartAmount());
        amounts.put("currAmt", model.getCurrentAmount());
        amounts.put("endAmt", model.getEndAmount());

        final SalaryGrade SalaryGrade = SalaryGradeFactory.getSalaryGrade(values, amounts);
        return SalaryGrade;
    }

    private SalaryGrade getUpdateEntity(FieldGroup binder) {
        final SalaryGradeModel model = ((BeanItem<SalaryGradeModel>) binder.getItemDataSource()).getBean();
        final SalaryGrade salaryGrade = JobFacade.salaryGradeService.findById(table.getValue().toString());
        final SalaryGrade updatedSalaryGrade = new SalaryGrade
                .Builder().copy(salaryGrade)
                .gradeName(model.getGradeName())
                .currencyId(model.getCurrencyId())
                .currentAmount(model.getCurrentAmount())
                .endAmount(model.getEndAmount())
                .midAmount(model.getMidAmount())
                .notes(model.getNotes())
                .startAmount(model.getStartAmount())
                .build();
        return updatedSalaryGrade;


    }

    private SalaryGradeModel getModel(SalaryGrade salaryGrade) {
        final SalaryGradeModel model = new SalaryGradeModel();
        model.setCurrencyId(salaryGrade.getCurrencyId());
        model.setCurrentAmount(salaryGrade.getCurrentAmount());
        model.setEndAmount(salaryGrade.getEndAmount());
        model.setGradeName(salaryGrade.getGradeName());
        model.setMidAmount(salaryGrade.getMidAmount());
        model.setNotes(salaryGrade.getNotes());
        model.setStartAmount(salaryGrade.getStartAmount());
        return model;
    }
}
