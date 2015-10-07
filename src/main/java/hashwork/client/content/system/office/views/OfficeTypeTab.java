package hashwork.client.content.system.office.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.office.OfficeMenu;
import hashwork.client.content.system.office.forms.OfficeTypeForm;
import hashwork.client.content.system.office.model.OfficeTypeModel;
import hashwork.client.content.system.office.table.OfficeTypeTable;
import hashwork.domain.office.OfficeType;
import hashwork.factories.office.OfficeTypeFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class OfficeTypeTab extends VerticalLayout
implements Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final OfficeTypeForm form;
    private final OfficeTypeTable table;

    public OfficeTypeTab(MainLayout app) {
        main = app;
        form = new OfficeTypeForm();
        table = new OfficeTypeTable(main);
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
            final OfficeType officeType = OfficeFacade.officeTypeService.findById(table.getValue().toString());
            final OfficeTypeModel model = getModel(officeType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            OfficeFacade.officeTypeService.save(getNewEntity(binder));
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
            OfficeFacade.officeTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        OfficeType OfficeType = OfficeFacade.officeTypeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            OfficeFacade.officeTypeService.delete(OfficeType);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new OfficeMenu(main, "OfficeType"));
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


    private OfficeType getNewEntity(FieldGroup binder) {
        final OfficeTypeModel model = ((BeanItem<OfficeTypeModel>) binder.getItemDataSource()).getBean();
        final OfficeType officeType = OfficeTypeFactory.getOfficeType(
                model.getName());
        return officeType;
    }

    private OfficeType getUpdateEntity(FieldGroup binder) {
        final OfficeTypeModel model = ((BeanItem<OfficeTypeModel>) binder.getItemDataSource()).getBean();
        final OfficeType officeType = OfficeFacade.officeTypeService.findById(table.getValue().toString());
        final OfficeType updatedOfficeType = new OfficeType
                .Builder().copy(officeType)
                .name(model.getName())
                .build();
        return updatedOfficeType;


    }

    private OfficeTypeModel getModel(OfficeType officeType) {
        final OfficeTypeModel model = new OfficeTypeModel();
        model.setName(officeType.getName());

        return model;
    }
}
