package hashwork.client.content.training.registration.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.LocationFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.training.registration.table.AllScheduledCoursesTable;
import hashwork.client.content.system.utilities.UtilitiesMenu;
import hashwork.domain.ui.location.LocationAddress;
import hashwork.domain.ui.util.Funder;
import hashwork.factories.office.OfficeFactory;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseScheduledTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HashWorkMain main;

    private final AllScheduledCoursesTable table;

    public CourseScheduledTab(HashWorkMain app) {
        main = app;

        table = new AllScheduledCoursesTable(main);
        setSizeFull();
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {

        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            UtilFacade.getFunderModelService().persist(getEntity(binder));
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
            UtilFacade.getFunderModelService().merge(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        UtilFacade.getFunderModelService().removeById(getEntity(binder).getId());
        getHome();
    }

    private Funder getEntity(FieldGroup binder) {
        final FunderBean funderBean = ((BeanItem<FunderBean>) binder.getItemDataSource()).getBean();
        final Location city = LocationFacade.getLocationModelService().findById(funderBean.getCity());
        final LocationAddress address = new OfficeFactory.LocationAddressBuilder(funderBean.getPostalAddress())
                .contactNumber(funderBean.getContactNumber())
                .physicalAddress(funderBean.getPhysicalAddress())
                .postalCode(funderBean.getPostalCode())
                .build();
        final Funder funder = new UtilFactory.FunderBuilder(funderBean.getTrainingFunderName())
                .costCenter(funderBean.getCostCenter())
                .city(city)
                .contact(address)
                .build();
        funder.setId(funderBean.getId());
        return funder;

    }

    private void getHome() {
        main.content.setSecondComponent(new UtilitiesMenu(main, "FUNDER"));
    }

    private void setEditFormProperties() {

    }

    private void setReadFormProperties() {

    }

    private void addListeners() {
        //Register Button Listeners

        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
    }

    private FunderBean getBean(Funder funder) {
        FunderBean bean = new FunderBean();
        bean.setCity(funder.getCity().getId());
        bean.setContactNumber(funder.getContact().getContactNumber());
        bean.setCostCenter(funder.getCostCenter());
        bean.setId(funder.getId());
        bean.setPhysicalAddress(funder.getContact().getPhysicalAddress());
        bean.setPostalAddress(funder.getContact().getPostalAddress());
        bean.setPostalCode(funder.getContact().getPostalCode());
        bean.setTrainingFunderName(funder.getTrainingFunderName());
        return bean;
    }
}