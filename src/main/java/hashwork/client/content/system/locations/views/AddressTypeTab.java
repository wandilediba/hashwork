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
import hashwork.client.content.system.locations.forms.AddressTypeForm;
import hashwork.client.content.system.locations.model.AddressTypeModel;
import hashwork.client.content.system.locations.table.AddressTypeTable;
import hashwork.domain.ui.location.AddressType;
import hashwork.factories.ui.location.AddressTypeFactory;

/**
 * Created by hashcode on 2015/09/07.
 */
public class AddressTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final AddressTypeForm form;
    private final AddressTypeTable table;

    public AddressTypeTab(MainLayout app) {
        main = app;
        form = new AddressTypeForm();
        table = new AddressTypeTable(main);
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
            final AddressType addressType = LocationFacade.addressTypeService.findById(table.getValue().toString());
            final AddressTypeModel model = getModel(addressType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LocationFacade.addressTypeService.save(getNewEntity(binder));
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
            LocationFacade.addressTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        AddressType addressType = LocationFacade.addressTypeService.findById(table.getValue().toString());
        LocationFacade.addressTypeService.delete(addressType);
        getHome();
    }



    private void getHome() {
        main.content.setSecondComponent(new LocationMenu(main, "ADDRESSTYPE"));
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

    private AddressType getNewEntity(FieldGroup binder) {
        final AddressTypeModel model = ((BeanItem<AddressTypeModel>) binder.getItemDataSource()).getBean();
        final AddressType AddressType = AddressTypeFactory.getAddressType(model.getAddressTypeName());
        return AddressType;
    }

    private AddressType getUpdateEntity(FieldGroup binder) {
        final AddressTypeModel bean = ((BeanItem<AddressTypeModel>) binder.getItemDataSource()).getBean();
        final AddressType AddressType = LocationFacade.addressTypeService.findById(table.getValue().toString());
        final AddressType updatedAddressType = new AddressType
                .Builder().copy(AddressType)
                .addressTypeName(bean.getAddressTypeName())
                .build();
        return updatedAddressType;
    }

    private AddressTypeModel getModel(AddressType addressType) {
        final AddressTypeModel model = new AddressTypeModel();
        model.setAddressTypeName(addressType.getAddressTypeName());
        return model;
    }
}