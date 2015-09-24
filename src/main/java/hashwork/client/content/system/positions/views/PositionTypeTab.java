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
import hashwork.client.content.system.positions.forms.PositionTypeForm;
import hashwork.client.content.system.positions.model.PositionTypeModel;
import hashwork.client.content.system.positions.table.PositionTypeTable;
import hashwork.domain.ui.position.PositionType;
import hashwork.factories.ui.position.PositionTypeFactory;


/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final PositionTypeForm form;
    private final PositionTypeTable table;

    public PositionTypeTab(MainLayout app) {
        main = app;
        form = new PositionTypeForm();
        table = new PositionTypeTable(main);
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
            final PositionType PositionType = PositionFacade.positionTypeService.findById(table.getValue().toString());
            final PositionTypeModel model = getModel(PositionType);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            PositionFacade.positionTypeService.save(getNewEntity(binder));
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
            PositionFacade.positionTypeService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        PositionType PositionType = PositionFacade.positionTypeService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            PositionFacade.positionTypeService.delete(PositionType);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "PositionType"));
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

    private PositionType getNewEntity(FieldGroup binder) {
        final PositionTypeModel model = ((BeanItem<PositionTypeModel>) binder.getItemDataSource()).getBean();
        final PositionType PositionType = PositionTypeFactory.getPositionType(
                model.getName()
        );
        return PositionType;
    }

    private PositionType getUpdateEntity(FieldGroup binder) {
        final PositionTypeModel model = ((BeanItem<PositionTypeModel>) binder.getItemDataSource()).getBean();
        final PositionType positionType = PositionFacade.positionTypeService.findById(table.getValue().toString());
        final PositionType updatedPositionType = new PositionType
                .Builder().copy(positionType)
                .name(model.getName())
                .build();
        return updatedPositionType;
    }

    private PositionTypeModel getModel(PositionType positionType) {
        final PositionTypeModel model = new PositionTypeModel();
        model.setName(model.getName());
        return model;
    }
}
