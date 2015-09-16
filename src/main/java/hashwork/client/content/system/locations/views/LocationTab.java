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
import hashwork.client.content.system.locations.forms.LocationForm;
import hashwork.client.content.system.locations.model.LocationModel;
import hashwork.client.content.system.locations.table.LocationTable;
import hashwork.domain.ui.location.Location;
import hashwork.factories.ui.location.LocationFactory;


/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final LocationForm form;
    private final LocationTable table;

    public LocationTab(MainLayout app) {
        main = app;
        form = new LocationForm();
        table = new LocationTable(main);
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
            final Location location = LocationFacade.locationService.findById(table.getValue().toString());
            final LocationModel model = getModel(location);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LocationFacade.locationService.save(getNewEntity(binder));
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
            LocationFacade.locationService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Location location = LocationFacade.locationService.findById(table.getValue().toString());
        if (LocationFacade.locationService.hasChildren(table.getValue().toString())) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            LocationFacade.locationService.delete(location);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new LocationMenu(main, "LOCATION"));
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


    private Location getNewEntity(FieldGroup binder) {
        final LocationModel model = ((BeanItem<LocationModel>) binder.getItemDataSource()).getBean();
        final Location location = LocationFactory.getLocation(
                model.getName(),
                model.getCode(),
                model.getLatitude(),
                model.getLongitude(),
                model.getLocationTypeId(),
                model.getChildrenIds(),
                model.getParentId());
        return location;
    }

    private Location getUpdateEntity(FieldGroup binder) {
        final LocationModel model = ((BeanItem<LocationModel>) binder.getItemDataSource()).getBean();
        final Location Location = LocationFacade.locationService.findById(table.getValue().toString());
        final Location updatedLocation = new Location
                .Builder().copy(Location)
                .name(model.getName())
                .code(model.getCode())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .locationTypeId(model.getLocationTypeId())
                .childrenIds(model.getChildrenIds())
                .parentId(model.getParentId())
                .build();
        return updatedLocation;


    }

    private LocationModel getModel(Location location) {
        final LocationModel model = new LocationModel();
        model.setChildrenIds(location.getChildrenIds());
        model.setCode(location.getCode());
        model.setLatitude(location.getLatitude());
        model.setLocationTypeId(location.getLocationTypeId());
        model.setLongitude(location.getLongitude());
        model.setName(location.getName());
        model.setParentId(location.getParentId());
        return model;
    }
}
