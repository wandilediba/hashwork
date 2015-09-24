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
import hashwork.client.content.system.jobs.forms.BenefitFrequencyForm;
import hashwork.client.content.system.jobs.model.BenefitFrequencyModel;
import hashwork.client.content.system.jobs.table.BenefitFrequencyTable;
import hashwork.domain.payroll.ui.job.BenefitFrequency;
import hashwork.factories.payroll.ui.Job.BenefitFrequencyFactory;


/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitFrequencyTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final BenefitFrequencyForm form;
    private final BenefitFrequencyTable table;

    public BenefitFrequencyTab(MainLayout app) {
        main = app;
        form = new BenefitFrequencyForm();
        table = new BenefitFrequencyTable(main);
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
            final BenefitFrequency BenefitFrequency = JobFacade.benefitFrequencyService.findById(table.getValue().toString());
            final BenefitFrequencyModel model = getModel(BenefitFrequency);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.benefitFrequencyService.save(getNewEntity(binder));
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
            JobFacade.benefitFrequencyService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        BenefitFrequency BenefitFrequency = JobFacade.benefitFrequencyService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            JobFacade.benefitFrequencyService.delete(BenefitFrequency);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new JobsMenu(main, "BenefitFrequency"));
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


    private BenefitFrequency getNewEntity(FieldGroup binder) {
        final BenefitFrequencyModel model = ((BeanItem<BenefitFrequencyModel>) binder.getItemDataSource()).getBean();
        final BenefitFrequency BenefitFrequency = BenefitFrequencyFactory.getBenefitFrequency(
                model.getFrequency());

        return BenefitFrequency;
    }

    private BenefitFrequency getUpdateEntity(FieldGroup binder) {
        final BenefitFrequencyModel model = ((BeanItem<BenefitFrequencyModel>) binder.getItemDataSource()).getBean();
        final BenefitFrequency benefitFrequency = JobFacade.benefitFrequencyService.findById(table.getValue().toString());
        final BenefitFrequency updatedBenefitFrequency = new BenefitFrequency
                .Builder().copy(benefitFrequency)
                .frequency(model.getFrequency())
                .build();
        return updatedBenefitFrequency;


    }

    private BenefitFrequencyModel getModel(BenefitFrequency benefitFrequency) {
        final BenefitFrequencyModel model = new BenefitFrequencyModel();
        model.setFrequency(benefitFrequency.getBenefitFrequency());
        return model;
    }
}
