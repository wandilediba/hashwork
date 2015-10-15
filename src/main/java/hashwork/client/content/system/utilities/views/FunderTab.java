package hashwork.client.content.system.utilities.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.utilities.UtilitiesMenu;
import hashwork.client.content.system.utilities.forms.FunderForm;
import hashwork.client.content.system.utilities.model.FunderModel;
import hashwork.client.content.system.utilities.table.FunderTable;
import hashwork.domain.ui.util.Funder;

/**
 * Created by hashcode on 2015/10/12.
 */
public class FunderTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final FunderForm form;
    private final FunderTable table;

    public FunderTab(MainLayout app) {
        main = app;
        form = new FunderForm();
        table = new FunderTable(main);
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
            final Funder funder = UtilFacade.funderService.findById(table.getValue().toString());
            final FunderModel bean = getBean(funder);
            form.binder.setItemDataSource(new BeanItem<FunderModel>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            UtilFacade.funderService.save(getEntity(binder));
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
            UtilFacade.funderService.save(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        UtilFacade.funderService.delete(getEntity(binder));
        getHome();
    }

    private Funder getEntity(FieldGroup binder) {
        final FunderModel funderBean = ((BeanItem<FunderModel>) binder.getItemDataSource()).getBean();
//        final Location city = LocationFacade.getLocationModelService().findById(funderBean.getCity());
//        final LocationAddress address = new OfficeFactory.LocationAddressBuilder(funderBean.getPostalAddress())
//                .contactNumber(funderBean.getContactNumber())
//                .physicalAddress(funderBean.getPhysicalAddress())
//                .postalCode(funderBean.getPostalCode())
//                .build();
        final Funder funder = new Funder.Builder()
//                .FunderBuilder(funderBean.getTrainingFunderName())
//                .costCenter(funderBean.getCostCenter())
//                .city(city)
//                .contact(address)
                .build();

        return funder;

    }

    private void getHome() {
        main.content.setSecondComponent(new UtilitiesMenu(main, "FUNDER"));
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

    private FunderModel getBean(Funder funder) {
        FunderModel bean = new FunderModel();
//        bean.setCity(funder.getCity().getId());
//        bean.setContactNumber(funder.getContact().getContactNumber());
//        bean.setCostCenter(funder.getCostCenter());
//        bean.setId(funder.getId());
//        bean.setPhysicalAddress(funder.getContact().getPhysicalAddress());
//        bean.setPostalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalCode(funder.getContact().getPostalCode());
        bean.setTrainingFunderName(funder.getTrainingFunderName());
        return bean;
    }
}