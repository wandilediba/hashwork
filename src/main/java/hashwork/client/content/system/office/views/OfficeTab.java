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
import hashwork.client.content.system.office.forms.OfficeForm;
import hashwork.client.content.system.office.model.OfficeModel;
import hashwork.client.content.system.office.table.OfficeTable;
import hashwork.domain.office.Office;
import hashwork.factories.office.OfficeFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zamzam on 2015/10/07.
 */
public class OfficeTab extends VerticalLayout
implements Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final OfficeForm form;
    private final OfficeTable table;

    public OfficeTab(MainLayout app) {
        main = app;
        form = new OfficeForm();
        table = new OfficeTable(main);
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
            final Office Office = OfficeFacade.officeService.findById(table.getValue().toString());
            final OfficeModel model = getModel(Office);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            OfficeFacade.officeService.save(getNewEntity(binder));
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
            OfficeFacade.officeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Office office = OfficeFacade.officeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            OfficeFacade.officeService.delete(office);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new OfficeMenu(main, "Office"));
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


    private Office getNewEntity(FieldGroup binder) {
        final OfficeModel model = ((BeanItem<OfficeModel>) binder.getItemDataSource()).getBean();
        Map<String, String> values = new HashMap<>();

        values.put("name", model.getName());
        values.put("active", model.getActive());
        values.put("description", model.getDescription());
        values.put("cityId", model.getCityId());
        values.put("contactId", model.getContactId());
        values.put("officeId", model.getOfficeTypeId());

        final Office office = OfficeFactory.getOffice(
                values,
                model.getDateEstablished(),
                model.getPositionIds());
        return office;
    }

    private Office getUpdateEntity(FieldGroup binder) {
        final OfficeModel model = ((BeanItem<OfficeModel>) binder.getItemDataSource()).getBean();
        final Office office = OfficeFacade.officeService.findById(table.getValue().toString());
        final Office updatedOffice = new Office
                .Builder().copy(office)
                .name(model.getName())
                .description(model.getDescription())
                .dateEstablished(model.getDateEstablished())
                .active(model.getActive())
                .officeTypeId(model.getOfficeTypeId())
                .cityId(model.getCityId())
                .contactId(model.getContactId())
                .positionIds(model.getPositionIds())
                .build();
        return updatedOffice;


    }

    private OfficeModel getModel(Office office) {
        final OfficeModel model = new OfficeModel();
        model.setName(office.getName());
        model.setDescription(office.getDescription());
        model.setDateEstablished(office.getDateEstablished());
        model.setActive(office.getActive());
        model.setOfficeTypeId(office.getOfficeTypeId());
        model.setCityId(office.getCityId());
        model.setContactId(office.getContactId());
        model.setPositionIds(office.getPositionIds());
        return model;
    }
}
