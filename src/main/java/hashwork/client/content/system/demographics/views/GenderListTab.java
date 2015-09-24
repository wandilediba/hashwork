package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.GenderListForm;
import hashwork.client.content.system.demographics.model.GenderListModel;
import hashwork.client.content.system.demographics.table.GenderListTable;
import hashwork.domain.ui.demographics.GenderList;
import hashwork.services.ui.demographics.GenderListService;
import hashwork.services.ui.demographics.Impl.GenderListServiceImpl;

/**
 * Created by hashcode on 2015/08/18.
 */
public class GenderListTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final GenderListService genderListService = new GenderListServiceImpl();
    private final MainLayout main;
    private final GenderListForm form;
    private final GenderListTable table;

    public GenderListTab(MainLayout app) {
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
            final GenderList genderList = genderListService.findById(table.getValue().toString());
            final GenderListModel model = getModel(genderList);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            genderListService.save(getNewEntity(binder));
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
            genderListService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        genderListService.delete(getNewEntity(binder));
        getHome();
    }



    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "GENDER"));
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

    private GenderList getNewEntity(FieldGroup binder) {
        final GenderListModel bean = ((BeanItem<GenderListModel>) binder.getItemDataSource()).getBean();
        final GenderList genderList = new GenderList.Builder().gender(bean.getGender()).build();

        return genderList;
    }

    private GenderList getUpdateEntity(FieldGroup binder) {
        final GenderListModel bean = ((BeanItem<GenderListModel>) binder.getItemDataSource()).getBean();
        final GenderList genderList = new GenderList.Builder().gender(bean.getGender()).build();

        return genderList;
    }

    private GenderListModel getModel(GenderList genderList) {
        final GenderListModel model = new GenderListModel();

        return model;
    }
}
