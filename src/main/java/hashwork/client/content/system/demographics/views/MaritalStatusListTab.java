package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.MaritalStatusListForm;
import hashwork.client.content.system.demographics.model.MaritalStatusListModel;
import hashwork.client.content.system.demographics.table.MaritalStatusListTable;
import hashwork.domain.ui.demographics.MaritalStatusList;
import hashwork.services.ui.demographics.Impl.MaritalStatusListServiceImpl;
import hashwork.services.ui.demographics.MaritalStatusListService;

/**
 * Created by hashcode on 2015/08/18.
 */
public class MaritalStatusListTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final MaritalStatusListService maritalStatusListService = new MaritalStatusListServiceImpl();

    private final MainLayout main;
    private final MaritalStatusListForm form;
    private final MaritalStatusListTable table;

    public MaritalStatusListTab(MainLayout app) {
        main = app;
        form = new MaritalStatusListForm();
        table = new MaritalStatusListTable(main);
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
            final MaritalStatusList maritalStatusList = maritalStatusListService.findById(table.getValue().toString());
            final MaritalStatusListModel model = getModel(maritalStatusList);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();

        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            maritalStatusListService.save(getEntity(binder));
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
            maritalStatusListService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        maritalStatusListService.update(getEntity(binder));
        getHome();
    }

    private MaritalStatusList getEntity(FieldGroup binder) {
        return ((BeanItem<MaritalStatusList>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "MARITAL"));
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

    private MaritalStatusList getNewEntity(FieldGroup binder) {
        final MaritalStatusListModel bean = ((BeanItem<MaritalStatusListModel>) binder.getItemDataSource()).getBean();
        final MaritalStatusList MaritalStatusList = new MaritalStatusList.Builder().statusName(bean.getStatusName()).build();

        return MaritalStatusList;
    }

    private MaritalStatusList getUpdateEntity(FieldGroup binder) {
        final MaritalStatusListModel bean = ((BeanItem<MaritalStatusListModel>) binder.getItemDataSource()).getBean();
        final MaritalStatusList MaritalStatusList = new MaritalStatusList.Builder().statusName(bean.getStatusName()).build();

        return MaritalStatusList;
    }

    private MaritalStatusListModel getModel(MaritalStatusList maritalStatusList) {
        final MaritalStatusListModel model = new MaritalStatusListModel();

        return model;
    }
}
