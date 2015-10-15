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
import hashwork.client.content.system.utilities.forms.DisciplineActionTypeListForm;
import hashwork.client.content.system.utilities.table.DisciplineActionTypeListTable;
import hashwork.domain.ui.util.DisciplineActionTypeList;

/**
 * Created by hashcode on 2015/10/12.
 */
public class DisciplineActionTypeListTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final DisciplineActionTypeListForm form;
    private final DisciplineActionTypeListTable table;

    public DisciplineActionTypeListTab(MainLayout app) {
        main = app;
        form = new DisciplineActionTypeListForm();
        table = new DisciplineActionTypeListTable(main);
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
            final DisciplineActionTypeList disciplineActionTypeList = UtilFacade.disciplineActionTypeListService.findById(table.getValue().toString());
            form.binder.setItemDataSource(new BeanItem<DisciplineActionTypeList>(disciplineActionTypeList));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            UtilFacade.disciplineActionTypeListService.save(getEntity(binder));
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
            UtilFacade.disciplineActionTypeListService.save(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        UtilFacade.disciplineActionTypeListService.delete(getEntity(binder));
        getHome();
    }

    private DisciplineActionTypeList getEntity(FieldGroup binder) {
        return ((BeanItem<DisciplineActionTypeList>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new UtilitiesMenu(main, "LANDING"));
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
        form.save.addClickListener((
                Button.ClickListener) this);
        form.edit.addClickListener((Button.ClickListener) this);
        form.cancel.addClickListener((Button.ClickListener) this);
        form.update.addClickListener((Button.ClickListener) this);
        form.delete.addClickListener((Button.ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }
}