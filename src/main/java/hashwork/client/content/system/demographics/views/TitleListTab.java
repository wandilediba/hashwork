package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.TitleListForm;
import hashwork.client.content.system.demographics.model.TitleListModel;
import hashwork.client.content.system.demographics.table.TitleListTable;
import hashwork.domain.ui.demographics.TitleList;
import hashwork.services.ui.demographics.Impl.TitleListServiceImpl;
import hashwork.services.ui.demographics.TitleListService;

/**
 * Created by hashcode on 2015/08/18.
 */
public class TitleListTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final TitleListService titleListService = new TitleListServiceImpl();
    private final MainLayout main;
    private final TitleListForm form;
    private final TitleListTable table;

    public TitleListTab(MainLayout app) {
        main = app;
        form = new TitleListForm();
        table = new TitleListTable(main);
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
            final TitleList locationType = titleListService.findById(table.getValue().toString());
            form.binder.setItemDataSource(new BeanItem<TitleList>(locationType));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            titleListService.save(getEntity(binder));
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
            titleListService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        titleListService.delete(getEntity(binder));
        getHome();
    }

    private TitleList getEntity(FieldGroup binder) {
        return ((BeanItem<TitleList>) binder.getItemDataSource()).getBean();

    }


    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "TITLE"));
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

    private TitleList getNewEntity(FieldGroup binder) {
        final TitleListModel bean = ((BeanItem<TitleListModel>) binder.getItemDataSource()).getBean();
        final TitleList TitleList = new TitleList();

        return TitleList;
    }

    private TitleList getUpdateEntity(FieldGroup binder) {
        final TitleListModel bean = ((BeanItem<TitleListModel>) binder.getItemDataSource()).getBean();
        final TitleList TitleList = new TitleList();

        return TitleList;
    }

    private TitleListModel getModel(TitleList TitleList) {
        final TitleListModel model = new TitleListModel();

        return model;
    }

}
