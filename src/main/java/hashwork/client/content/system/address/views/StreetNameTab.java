/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.address.AddressMenu;
import hashwork.client.content.system.demographics.forms.GenderListForm;
import hashwork.client.content.system.demographics.table.GenderListTable;
import hashwork.domain.ui.address.StreetName;
import hashwork.services.ui.address.Impl.StreetNameServiceImpl;
import hashwork.services.ui.address.StreetNameService;

/**
 *
 * @author Garran
 */
public class StreetNameTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final StreetNameService streetNameService = new StreetNameServiceImpl();
    private final MainLayout main;
    private final GenderListForm form;
    private final GenderListTable table;
    
    public StreetNameTab(MainLayout app) {
        main = app;
        form = new GenderListForm();
        table = new GenderListTable(main);
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
            final StreetName locationType = streetNameService.findById(table.getValue().toString());
            form.binder.setItemDataSource(new BeanItem<StreetName>(locationType));
            setReadFormProperties();
        }
    }
    
    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            streetNameService.save(getEntity(binder));
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
            streetNameService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        streetNameService.delete(getEntity(binder));
        getHome();
    }

    private StreetName getEntity(FieldGroup binder) {
        return ((BeanItem<StreetName>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new AddressMenu(main, "Vent Road"));
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
    
}
