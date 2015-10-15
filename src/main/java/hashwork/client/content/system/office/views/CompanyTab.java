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
import hashwork.client.content.system.office.forms.CompanyForm;
import hashwork.client.content.system.office.model.CompanyModel;
import hashwork.client.content.system.office.table.CompanyTable;
import hashwork.domain.office.Company;
import hashwork.domain.office.Office;
import hashwork.factories.office.CompanyFactory;

/**
 * Created by zamzam on 2015/10/07.
 */
public class CompanyTab extends VerticalLayout
implements Button.ClickListener, Property.ValueChangeListener{
    private final MainLayout main;
    private final CompanyForm form;
    private final CompanyTable table;

    public CompanyTab(MainLayout app) {
        main = app;
        form = new CompanyForm();
        table = new CompanyTable(main);
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
            final Company Company = OfficeFacade.companyService.findById(table.getValue().toString());
            final CompanyModel model = getModel(Company);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            OfficeFacade.companyService.save(getNewEntity(binder));
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
            OfficeFacade.companyService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Company location = OfficeFacade.companyService.findById(table.getValue().toString());
        if (false) {
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        } else {
            OfficeFacade.companyService.delete(location);
            getHome();
        }
    }



    private void getHome() {
        main.content.setSecondComponent(new OfficeMenu(main, "Company"));
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

    private Company getNewEntity(FieldGroup binder) {
        final CompanyModel model = ((BeanItem<CompanyModel>) binder.getItemDataSource()).getBean();
        final Company company = CompanyFactory.getCompany(model.getName());
        return company;
    }

    private Company getUpdateEntity(FieldGroup binder) {
        final CompanyModel bean = ((BeanItem<CompanyModel>) binder.getItemDataSource()).getBean();
        final Company company = OfficeFacade.companyService.findById(table.getValue().toString());
        final Company updatedCompany = new Company
                .Builder().copy(company)
                .name(bean.getName())
                .build();
        return updatedCompany;
    }

    private CompanyModel getModel(Company company) {
        final CompanyModel model = new CompanyModel();
        model.setName(company.getName());

        return model;
    }
}
