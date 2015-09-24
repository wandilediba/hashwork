package hashwork.client.content.system.positions.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.PositionFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.positions.PositionTabValues;
import hashwork.client.content.system.positions.PositionsMenu;
import hashwork.client.content.system.positions.forms.PositionForm;
import hashwork.client.content.system.positions.model.PositionModel;
import hashwork.client.content.system.positions.table.PositionTable;
import hashwork.domain.ui.position.Position;
import hashwork.factories.ui.position.PositionFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final PositionForm form;
    private final PositionTable table;

    public PositionTab(MainLayout app) {
        main = app;
        form = new PositionForm();
        table = new PositionTable(main);
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
            final Position Position = PositionFacade.positionService.findById(table.getValue().toString());
            final PositionModel model = getModel(Position);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            PositionFacade.positionService.save(getNewEntity(binder));
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
            PositionFacade.positionService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Position Position = PositionFacade.positionService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            PositionFacade.positionService.delete(Position);
            getHome();
        }
    }


    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, PositionTabValues.POSITION.name()));
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


    private Position getNewEntity(FieldGroup binder) {
        final PositionModel model = ((BeanItem<PositionModel>) binder.getItemDataSource()).getBean();
        final Map<String, Date> dates = new HashMap<>();
        dates.put("postionEntryDate", model.getPostionEntryDate());
        dates.put("positionEndDate", model.getPositionEndDate());

        final Map<String, String> values = new HashMap<>();
        values.put("positionCode", model.getPositionCode());
        values.put("positionTitle", model.getPositionTitle());
        values.put("description", model.getDescription());
        values.put("currentOccupantId", model.getCurrentOccupantId());
        values.put("positionTypeId", model.getPositionTypeId());
        values.put("positionStatusId", model.getPositionStatusId());
        values.put("positionComments", model.getPositionComments());
        values.put("officeId", model.getOfficeId());
        values.put("supervisorId", model.getSupervisorId());
        values.put("departmentId", model.getDepartmentId());
        values.put("jobId", model.getJobId());

        final Position Position = PositionFactory.getPosition(values, dates);
        return Position;
    }

    private Position getUpdateEntity(FieldGroup binder) {
        final PositionModel model = ((BeanItem<PositionModel>) binder.getItemDataSource()).getBean();
        final Position Position = PositionFacade.positionService.findById(table.getValue().toString());
        final Position updatedPosition = new Position
                .Builder().copy(Position)
                .currentOccupantId(model.getCurrentOccupantId())
                .departmentId(model.getDepartmentId())
                .description(model.getDescription())
                .jobId(model.getJobId())
                .officeId(model.getOfficeId())
                .positionCode(model.getPositionCode())
                .positionComments(model.getPositionComments())
                .positionEndDate(model.getPositionEndDate())
                .positionStatusId(model.getPositionStatusId())
                .positionTitle(model.getPositionTitle())
                .positionTypeId(model.getPositionTypeId())
                .postionEntryDate(model.getPositionEndDate())
                .supervisorId(model.getSupervisorId())
                .build();
        return updatedPosition;
    }

    private PositionModel getModel(Position position) {
        final PositionModel model = new PositionModel();
        model.setCurrentOccupantId(position.getCurrentOccupantId());
        model.setDepartmentId(position.getDepartmentId());
        model.setDescription(position.getDescription());
        model.setJobId(position.getJobId());
        model.setOfficeId(position.getOfficeId());
        model.setPositionCode(position.getPositionCode());
        model.setPositionComments(position.getPositionComments());
        model.setPositionEndDate(position.getPositionEndDate());
        model.setPositionStatusId(position.getPositionStatusId());
        model.setPositionTitle(position.getPositionTitle());
        model.setPositionTypeId(position.getPositionTypeId());
        model.setPostionEntryDate(position.getPostionEntryDate());
        model.setSupervisorId(position.getSupervisorId());

        return model;
    }
}
