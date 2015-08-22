package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.RolesListForm;
import hashwork.client.content.system.demographics.model.RolesListModel;
import hashwork.client.content.system.demographics.table.RolesListTable;
import hashwork.domain.ui.demographics.RolesList;
import hashwork.services.ui.demographics.Impl.RolesListServiceImpl;
import hashwork.services.ui.demographics.RolesListService;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RolesListTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {
    private final RolesListService rolesListService = new RolesListServiceImpl();
    private final MainLayout main;
    private final RolesListForm form;
    private final RolesListTable table;

    public RolesListTab(MainLayout app) {
        main = app;
        form = new RolesListForm();
        table = new RolesListTable(main);
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
            final RolesList rolesList = rolesListService.findById(table.getValue().toString());
            final RolesListModel model = getModel(rolesList);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            rolesListService.save(getEntity(binder));
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
            rolesListService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        rolesListService.delete(getEntity(binder));
        getHome();
    }

    private RolesList getEntity(FieldGroup binder) {
        return ((BeanItem<RolesList>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "LANDING"));
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

    private RolesList getNewEntity(FieldGroup binder) {
        final RolesListModel bean = ((BeanItem<RolesListModel>) binder.getItemDataSource()).getBean();
        final RolesList RolesList = new RolesList
                .Builder()
                .description(bean.getDescription())
                .roleName(bean.getRoleName()).build();

        return RolesList;
    }

    private RolesList getUpdateEntity(FieldGroup binder) {
        final RolesListModel bean = ((BeanItem<RolesListModel>) binder.getItemDataSource()).getBean();
        final RolesList RolesList = new RolesList
                .Builder()
                .description(bean.getDescription())
                .roleName(bean.getRoleName()).build();

        return RolesList;
    }

    private RolesListModel getModel(RolesList rolesList) {
        final RolesListModel model = new RolesListModel();

        return model;
    }
}
