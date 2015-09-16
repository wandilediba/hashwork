package hashwork.client.content.system.locations.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.LocationFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.locations.LocationMenu;
import hashwork.client.content.system.locations.forms.RegistrationBodyForm;
import hashwork.client.content.system.locations.model.RegistrationBodyModel;
import hashwork.client.content.system.locations.table.RegistrationBodyTable;
import hashwork.domain.ui.location.RegistrationBody;
import hashwork.factories.ui.location.RegistrationBodyFactory;

/**
 * Created by hashcode on 2015/09/07.
 */
public class RegistrationBodyTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final RegistrationBodyForm form;
    private final RegistrationBodyTable table;

    public RegistrationBodyTab(MainLayout app) {
        main = app;
        form = new RegistrationBodyForm();
        table = new RegistrationBodyTable(main);
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
            final RegistrationBody registrationBody = LocationFacade.registrationBodyService.findById(table.getValue().toString());
            final RegistrationBodyModel model = getModel(registrationBody);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LocationFacade.registrationBodyService.save(getNewEntity(binder));
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
            LocationFacade.registrationBodyService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        RegistrationBody registrationBody = LocationFacade.registrationBodyService.findById(table.getValue().toString());
        LocationFacade.registrationBodyService.delete(registrationBody);
        getHome();
    }



    private void getHome() {
        main.content.setSecondComponent(new LocationMenu(main, "REGISTRATIONBODY"));
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
        form.save.addClickListener((Button.ClickListener) this);
        form.edit.addClickListener((Button.ClickListener) this);
        form.cancel.addClickListener((Button.ClickListener) this);
        form.update.addClickListener((Button.ClickListener) this);
        form.delete.addClickListener((Button.ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private RegistrationBody getNewEntity(FieldGroup binder) {
        final RegistrationBodyModel model = ((BeanItem<RegistrationBodyModel>) binder.getItemDataSource()).getBean();
        final RegistrationBody RegistrationBody = RegistrationBodyFactory.getRegistrationBody
                (model.getName(),
                        model.getDescription(),
                        model.getCoreActivity(),
                        model.getActive(),
                        model.getAsOfDate());
        return RegistrationBody;
    }

    private RegistrationBody getUpdateEntity(FieldGroup binder) {
        final RegistrationBodyModel bean = ((BeanItem<RegistrationBodyModel>) binder.getItemDataSource()).getBean();
        final RegistrationBody RegistrationBody = LocationFacade.registrationBodyService.findById(table.getValue().toString());
        final RegistrationBody updatedRoleList = new RegistrationBody
                .Builder().copy(RegistrationBody)
                .description(bean.getDescription())
                .name(bean.getName())
                .coreActivity(bean.getActive())
                .active(bean.getActive())
                .asOfDate(bean.getAsOfDate())
                .build();
        return updatedRoleList;
    }

    private RegistrationBodyModel getModel(RegistrationBody registrationBody) {
        final RegistrationBodyModel model = new RegistrationBodyModel();
        model.setDescription(registrationBody.getDescription());
        model.setName(registrationBody.getName());
        model.setActive(registrationBody.getActive());
        model.setCoreActivity(registrationBody.getCoreActivity());
        model.setAsOfDate(registrationBody.getAsOfDate());
        return model;
    }
}
