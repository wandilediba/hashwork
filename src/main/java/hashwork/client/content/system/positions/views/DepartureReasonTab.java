package hashwork.client.content.system.positions.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.PositionFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.positions.PositionsMenu;
import hashwork.client.content.system.positions.forms.DepartureReasonForm;
import hashwork.client.content.system.positions.model.DepartureReasonModel;
import hashwork.client.content.system.positions.table.DepartureReasonTable;
import hashwork.domain.ui.position.DepartureReason;
import hashwork.factories.ui.position.DepartureReasonFactory;


/**
 * Created by hashcode on 2015/09/16.
 */
public class DepartureReasonTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final DepartureReasonForm form;
    private final DepartureReasonTable table;

    public DepartureReasonTab(MainLayout app) {
        main = app;
        form = new DepartureReasonForm();
        table = new DepartureReasonTable(main);
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
            final DepartureReason DepartureReason = PositionFacade.departureReasonService.findById(table.getValue().toString());
            final DepartureReasonModel model = getModel(DepartureReason);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            PositionFacade.departureReasonService.save(getNewEntity(binder));
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
            PositionFacade.departureReasonService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        DepartureReason DepartureReason = PositionFacade.departureReasonService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            PositionFacade.departureReasonService.delete(DepartureReason);
            getHome();
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "DepartureReason"));
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


    private DepartureReason getNewEntity(FieldGroup binder) {
        final DepartureReasonModel model = ((BeanItem<DepartureReasonModel>) binder.getItemDataSource()).getBean();
        final DepartureReason departureReason = DepartureReasonFactory.getDepartureReason(
                model.getReasonName(),
                model.getReasonName());
        return departureReason;
    }

    private DepartureReason getUpdateEntity(FieldGroup binder) {
        final DepartureReasonModel model = ((BeanItem<DepartureReasonModel>) binder.getItemDataSource()).getBean();
        final DepartureReason departureReason = PositionFacade.departureReasonService.findById(table.getValue().toString());
        final DepartureReason updatedDepartureReason = new DepartureReason
                .Builder().copy(departureReason)
                .reasonName(model.getReasonName())
                .description(model.getDescription())
                .build();
        return updatedDepartureReason;
    }

    private DepartureReasonModel getModel(DepartureReason departureReason) {
        final DepartureReasonModel model = new DepartureReasonModel();
        model.setDescription(departureReason.getDescription());
        model.setReasonName(departureReason.getReasonName());
        return model;
    }
}
