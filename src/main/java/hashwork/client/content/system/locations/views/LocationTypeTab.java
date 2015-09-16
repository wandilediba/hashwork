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
import hashwork.client.content.system.locations.forms.LocationTypeForm;
import hashwork.client.content.system.locations.model.LocationTypeModel;
import hashwork.client.content.system.locations.table.LocationTypeTable;
import hashwork.domain.ui.location.LocationType;
import hashwork.factories.ui.location.LocationTypeFactory;

/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final LocationTypeForm form;
    private final LocationTypeTable table;

    public LocationTypeTab(MainLayout app) {
        main = app;
        form = new LocationTypeForm();
        table = new LocationTypeTable(main);
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
            final LocationType locationType = LocationFacade.locationTypeService.findById(table.getValue().toString());
            final LocationTypeModel model = getModel(locationType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LocationFacade.locationTypeService.save(getNewEntity(binder));
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
            LocationFacade.locationTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        LocationType locationType = LocationFacade.locationTypeService.findById(table.getValue().toString());
        LocationFacade.locationTypeService.delete(locationType);
        getHome();
    }



    private void getHome() {
        main.content.setSecondComponent(new LocationMenu(main, "LANDING"));
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

    private LocationType getNewEntity(FieldGroup binder) {
        final LocationTypeModel bean = ((BeanItem<LocationTypeModel>) binder.getItemDataSource()).getBean();
        final LocationType LocationType = LocationTypeFactory
                .getLocationType(bean.getName(), bean.getCode());
        return LocationType;
    }

    private LocationType getUpdateEntity(FieldGroup binder) {
        final LocationTypeModel bean = ((BeanItem<LocationTypeModel>) binder.getItemDataSource()).getBean();
        final LocationType LocationType = LocationFacade.locationTypeService.findById(table.getValue().toString());
        final LocationType updatedRoleList = new LocationType
                .Builder().copy(LocationType)
                .name(bean.getName())
                .code(bean.getCode()).build();
        return updatedRoleList;
    }

    private LocationTypeModel getModel(LocationType LocationType) {
        final LocationTypeModel model = new LocationTypeModel();
        model.setName(LocationType.getName());
        model.setCode(LocationType.getCode());

        return model;
    }

}
