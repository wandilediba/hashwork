package hashwork.client.content.training.registration.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.utilities.UtilitiesMenu;
import hashwork.client.content.system.utilities.model.FunderModel;
import hashwork.client.content.training.registration.table.AllScheduledCoursesTable;
import hashwork.domain.ui.util.Funder;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseScheduledTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;

    private final AllScheduledCoursesTable table;

    public CourseScheduledTab(MainLayout app) {
        main = app;

        table = new AllScheduledCoursesTable(main);
        setSizeFull();
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();

    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {

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

                .build();

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
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private FunderModel getBean(Funder funder) {
        FunderModel bean = new FunderModel();

        return bean;
    }
}