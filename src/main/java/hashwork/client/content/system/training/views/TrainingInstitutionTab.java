package hashwork.client.content.system.training.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.LocationFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.system.training.TrainingMenu;
import hashwork.domain.ui.location.LocationAddress;
import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.factories.office.OfficeFactory;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingInstitutionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HashWorkMain main;
    private final TrainingInstitutionForm form;
    private final TrainingInstitutionTable table;

    public TrainingInstitutionTab(HashWorkMain app) {
        main = app;
        form = new TrainingInstitutionForm();
        table = new TrainingInstitutionTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
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
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final TrainingInstitution trainingInstitution = TrainingFacade.getTrainingInstitutionModelService().findById(table.getValue().toString());
            final TrainingInstitutionBean bean = getBean(trainingInstitution);
            form.binder.setItemDataSource(new BeanItem<TrainingInstitutionBean>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TrainingFacade.getTrainingInstitutionModelService().persist(getEntity(binder));
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
            TrainingFacade.getTrainingInstitutionModelService().merge(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.getTrainingInstitutionModelService().removeById(getEntity(binder).getId());
        getHome();
    }

    private TrainingInstitution getEntity(FieldGroup binder) {
        final TrainingInstitutionBean trainingInstitutionBean = ((BeanItem<TrainingInstitutionBean>) binder.getItemDataSource()).getBean();
        final Location city = LocationFacade.getLocationModelService().findById(trainingInstitutionBean.getCity());
        final LocationAddress address = new OfficeFactory.LocationAddressBuilder(trainingInstitutionBean.getPostalAddress())
                .contactNumber(trainingInstitutionBean.getContactNumber())
                .physicalAddress(trainingInstitutionBean.getPhysicalAddress())
                .postalCode(trainingInstitutionBean.getPostalCode())
                .build();
        final TrainingInstitution trainingInstitution = new TrainingFactory
                .TrainingInstitutionBuilder(trainingInstitutionBean.getTrainingInstitution())
                .city(city)
                .contact(address)
                .build();
        trainingInstitution.setId(trainingInstitutionBean.getId());
        return trainingInstitution;

    }

    private void getHome() {
        main.content.setSecondComponent(new TrainingMenu(main, "TRAINING"));
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
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
    }

    private TrainingInstitutionBean getBean(TrainingInstitution trainingInstitution) {
        TrainingInstitutionBean bean = new TrainingInstitutionBean();
        bean.setCity(trainingInstitution.getCity().getId());
        bean.setContactNumber(trainingInstitution.getContact().getContactNumber());
        bean.setId(trainingInstitution.getId());
        bean.setPhysicalAddress(trainingInstitution.getContact().getPhysicalAddress());
        bean.setPostalAddress(trainingInstitution.getContact().getPostalAddress());
        bean.setPostalCode(trainingInstitution.getContact().getPostalCode());
        bean.setTrainingInstitution(trainingInstitution.getTrainingInstitution());
        return bean;
    }
}