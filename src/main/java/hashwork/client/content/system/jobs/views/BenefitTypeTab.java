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
import hashwork.client.content.system.jobs.forms.BenefitTypeForm;
import hashwork.client.content.system.jobs.model.BenefitTypeModel;
import hashwork.client.content.system.jobs.table.BenefitTypeTable;
import hashwork.domain.payroll.ui.job.BenefitType;
import hashwork.factories.payroll.ui.Job.BenefitTypeFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final BenefitTypeForm form;
    private final BenefitTypeTable table;

    public BenefitTypeTab(MainLayout app) {
        main = app;
        form = new BenefitTypeForm();
        table = new BenefitTypeTable(main);
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
            final BenefitType BenefitType = JobFacade.benefitTypeService.findById(table.getValue().toString());
            final BenefitTypeModel model = getModel(BenefitType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.benefitTypeService.save(getNewEntity(binder));
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
            JobFacade.benefitTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        final BenefitType BenefitType = JobFacade.benefitTypeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            JobFacade.benefitTypeService.delete(BenefitType);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new JobsMenu(main, JobsTabValues.BENEFITTYPE.name()));
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


    private BenefitType getNewEntity(FieldGroup binder) {
        final BenefitTypeModel model = ((BeanItem<BenefitTypeModel>) binder.getItemDataSource()).getBean();
        Map<String, String> values = new HashMap<>();
        values.put("benefitTypeName", model.getBenefitTypeName());
        values.put("currencyId", model.getCurrencyId());
        final BenefitType benefitType = BenefitTypeFactory.getBenefitType(values, model.getAmount());
        return benefitType;
    }

    private BenefitType getUpdateEntity(FieldGroup binder) {
        final BenefitTypeModel model = ((BeanItem<BenefitTypeModel>) binder.getItemDataSource()).getBean();
        final BenefitType BenefitType = JobFacade.benefitTypeService.findById(table.getValue().toString());
        final BenefitType updatedBenefitType = new BenefitType
                .Builder().copy(BenefitType)
                .benefitTypeName(model.getBenefitTypeName())
                .amount(model.getAmount())
                .currencyId(model.getCurrencyId())
                .build();
        return updatedBenefitType;
    }

    private BenefitTypeModel getModel(BenefitType benefitType) {
        final BenefitTypeModel model = new BenefitTypeModel();
        model.setAmount(benefitType.getAmount());
        model.setBenefitTypeName(model.getBenefitTypeName());
        model.setCurrencyId(model.getCurrencyId());
        return model;
    }
}
