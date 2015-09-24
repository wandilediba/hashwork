package hashwork.client.content.system.demographics.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.demographics.forms.LanguageProficiencyForm;
import hashwork.client.content.system.demographics.model.LanguageProficiencyModel;
import hashwork.client.content.system.demographics.table.LanguageProficiencyTable;
import hashwork.domain.ui.demographics.LanguageProficiency;
import hashwork.services.ui.demographics.Impl.LanguageProficiencyServiceImpl;
import hashwork.services.ui.demographics.LanguageProficiencyService;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LanguageProficiencyTab extends VerticalLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final LanguageProficiencyService languageProficiencyService = new LanguageProficiencyServiceImpl();
    private final LanguageProficiencyForm form;
    private final LanguageProficiencyTable table;

    public LanguageProficiencyTab(MainLayout app) {
        main = app;
        form = new LanguageProficiencyForm();
        table = new LanguageProficiencyTable(main);
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

            final LanguageProficiency languageProficiency = languageProficiencyService.findById(table.getValue().toString());
            final LanguageProficiencyModel model = getModel(languageProficiency);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            languageProficiencyService.save(getEntity(binder));
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
            languageProficiencyService.update(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        languageProficiencyService.delete(getEntity(binder));
        getHome();
    }

    private LanguageProficiency getEntity(FieldGroup binder) {
        return ((BeanItem<LanguageProficiency>) binder.getItemDataSource()).getBean();

    }

    private void getHome() {
        main.content.setSecondComponent(new DemographicsMenu(main, "PROFICIENCY"));
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

    private LanguageProficiency getNewEntity(FieldGroup binder) {
        final LanguageProficiencyModel bean = ((BeanItem<LanguageProficiencyModel>) binder.getItemDataSource()).getBean();
        final LanguageProficiency LanguageProficiency = new LanguageProficiency
                .Builder()
                .proficiency(bean.getProficiency())
                .build();

        return LanguageProficiency;
    }

    private LanguageProficiency getUpdateEntity(FieldGroup binder) {
        final LanguageProficiencyModel bean = ((BeanItem<LanguageProficiencyModel>) binder.getItemDataSource()).getBean();
        final LanguageProficiency LanguageProficiency = new LanguageProficiency
                .Builder()
                .proficiency(bean.getProficiency())
                .build();

        return LanguageProficiency;
    }

    private LanguageProficiencyModel getModel(LanguageProficiency languageProficiency) {
        final LanguageProficiencyModel model = new LanguageProficiencyModel();

        return model;
    }
}
