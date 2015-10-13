package hashwork.client.content.training.registration.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.training.model.TrainingInstitutionModel;
import hashwork.client.content.training.registration.InstitutionRegistrationMenu;
import hashwork.client.content.training.registration.forms.TrainingInstitutionForm;
import hashwork.client.content.training.registration.table.TrainingInstitutionTable;
import hashwork.domain.office.LocationAddress;
import hashwork.domain.ui.location.Location;
import hashwork.domain.ui.training.TrainingInstitution;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RegisterInstitutionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final TrainingInstitutionForm form;
    private final TrainingInstitutionTable table;

    public RegisterInstitutionTab(MainLayout app) {
        main = app;
        form = new TrainingInstitutionForm();
        table = new TrainingInstitutionTable(main);
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
            final TrainingInstitution trainingInstitution = TrainingFacade.trainingInstitutionService.findById(table.getValue().toString());
            final TrainingInstitutionModel bean = getBean(trainingInstitution);
            form.binder.setItemDataSource(new BeanItem<TrainingInstitutionModel>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TrainingInstitution trainingInstitution = getEntity(binder);
            TrainingFacade.trainingInstitutionService.save(trainingInstitution);
            createInstitutionContact(trainingInstitution);
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
            TrainingFacade.trainingInstitutionService.save(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.trainingInstitutionService.delete((getEntity(binder)));
        getHome();
    }

    private TrainingInstitution getEntity(FieldGroup binder) {
        final TrainingInstitutionModel trainingInstitutionBean = ((BeanItem<TrainingInstitutionModel>) binder.getItemDataSource()).getBean();
//        final Location city = LocationFacade.getLocationModelService().findById(trainingInstitutionBean.getCity());
//        final LocationAddress address = new OfficeFactory.LocationAddressBuilder(trainingInstitutionBean.getPostalAddress())
//                .contactNumber(trainingInstitutionBean.getContactNumber())
//                .physicalAddress(trainingInstitutionBean.getPhysicalAddress())
//                .postalCode(trainingInstitutionBean.getPostalCode())
//                .emailAddress(trainingInstitutionBean.getEmailAddress())
//                .build();
        final TrainingInstitution trainingInstitution = new TrainingInstitution.Builder()
//                .city(city)
//                .contact(address)
                .build();

        return trainingInstitution;

    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionRegistrationMenu(main, "LANDING"));
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

    private TrainingInstitutionModel getBean(TrainingInstitution trainingInstitution) {
        //REFACTOR Law of Demeter Violation
        TrainingInstitutionModel bean = new TrainingInstitutionModel();
//


        return bean;
    }

    private String getEmailAddress(LocationAddress contact) {
        if (contact != null)
            return contact.getEmailAddress();
        return null;
    }

    private String getCityName(Location city) {
        if (city != null)
            return city.getName();
        return null;
    }

    private String getContactNumber(LocationAddress contact) {
        if (contact != null)
            return contact.getContactNumber();
        return null;
    }

    private String getPostalAddress(LocationAddress contact) {
        if (contact != null)
            return contact.getPostalAddress();
        return null;
    }

    private String getPhysicalAddress(LocationAddress contact) {
        if (contact != null)
            return contact.getPhysicalAddress();
        return null;
    }

    private String getPostalCode(LocationAddress contact) {
        if (contact != null)
            return contact.getPostalCode();
        return null;
    }

    private void createInstitutionContact(TrainingInstitution trainingInstitution) {
//        RolesList rolesList = DemographicsFacade.getRolesListModelService().getByPropertyName("rolename", "ROLE_TRAINER");
//        PersonRole role = PersonFactory.getPersonRole(rolesList);
//        List<PersonRole> roles = new ArrayList<PersonRole>();
//        roles.add(role);
//
//        Person person = new PersonFactory.PersonBuilder(trainingInstitution.getTrainingInstitution(), "Training Institution")
//                .authvalue("test123") //Replace with a password Service Connected to Mail
//                .emailAdress(trainingInstitution.getContact().getEmailAddress())
//                .personRoles(roles)
//                .build();
//        PersonFacade.getEmployeeModelService().persist(person);
    }
}