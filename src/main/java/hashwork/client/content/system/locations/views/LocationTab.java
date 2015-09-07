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
import hashwork.domain.ui.location.LocationType;
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
            final LocationModel locationBean = getLocationModel(location);
            form.binder.setItemDataSource(new BeanItem<LocationModel>(locationBean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();

            LocationFacade.locationService.save(getEntity(binder));
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
            LocationFacade.locationService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
//        LocationFacade.locationService.delete(getEntity(binder).getId());
        getHome();
    }

    private Location getEntity(FieldGroup binder) {
        Location location = getLocation(((BeanItem<LocationModel>) binder.getItemDataSource()).getBean());

        return location;

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

    private Location getLocation(LocationModel model) {
        LocationType lt = LocationFacade.locationTypeService.findById(model.getLocationTypeId());
        Location parent = null;
        if (model.getParentId() != null) {
            parent = LocationFacade.locationService.findById(model.getParentId());
        }

        Location location = new LocationFactory().getLocation(
                model.getName(),
                model.getCode(),
                model.getLatitude(),
                model.getLongitude(),
                model.getLocationTypeId(),
                model.getChildrenIds(),
                model.getParentId()
        );
        return location;
    }

    private LocationModel getLocationModel(Location location) {
        LocationModel locationModel = new LocationModel();
        locationModel.setCode(location.getCode());
        locationModel.setLatitude(location.getLatitude());
        locationModel.setLocationTypeId(location.getLocationTypeId());
        locationModel.setLongitude(location.getLongitude());
        locationModel.setName(location.getName());
        locationModel.setParentId(location.getParentId());
        return locationModel;
    }

    private String getParentId(Location parent) {
        if (parent != null) {
            return parent.getName();
        }
        return null;
    }

    private String getLocationId(LocationType locationType) {
        if (locationType != null)
            return locationType.getId();
        return null;

    }
}
