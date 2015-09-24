package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.RaceListForm;
import hashwork.client.content.system.demographics.model.RaceListModel;
import hashwork.client.content.system.demographics.table.RaceListTable;
import hashwork.domain.ui.demographics.RaceList;
import hashwork.services.ui.demographics.Impl.RaceListServiceImpl;
import hashwork.services.ui.demographics.RaceListService;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RaceListTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final RaceListService raceListService = new RaceListServiceImpl();
    private final MainLayout main;
    private final RaceListForm form;
    private final RaceListTable table;

    public RaceListTab(MainLayout app) {
        main = app;
        form = new RaceListForm();
        table = new RaceListTable(main);
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
            final RaceList raceList = raceListService.findById(table.getValue().toString());
            final RaceListModel model = getModel(raceList);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();

        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            raceListService.save(getEntity(binder));
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
            raceListService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }
    private void deleteForm(FieldGroup binder) {
        raceListService.delete(getEntity(binder));
        getHome();
    }

    private RaceList getEntity(FieldGroup binder) {
        return ((BeanItem<RaceList>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "RACE"));
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

    private RaceList getNewEntity(FieldGroup binder) {
        final RaceListModel bean = ((BeanItem<RaceListModel>) binder.getItemDataSource()).getBean();
        final RaceList RaceList = new RaceList();

        return RaceList;
    }

    private RaceList getUpdateEntity(FieldGroup binder) {
        final RaceListModel bean = ((BeanItem<RaceListModel>) binder.getItemDataSource()).getBean();
        final RaceList RaceList = new RaceList();

        return RaceList;
    }

    private RaceListModel getModel(RaceList raceList) {
        final RaceListModel model = new RaceListModel();

        return model;
    }
}
