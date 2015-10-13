package hashwork.client.content.system.training.tables;

import com.vaadin.ui.Table;
import hashwork.app.facade.LocationFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.LocationAddress;
import hashwork.domain.ui.location.Location;
import hashwork.domain.ui.training.TrainingInstitution;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingInstitutionTable extends Table {

    private final MainLayout main;

    public TrainingInstitutionTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Institution Name", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Postal  Address", String.class, null);
        addContainerProperty("Physical Address", String.class, null);
        addContainerProperty("Postal Code", String.class, null);
        addContainerProperty("City", String.class, null);


        // Add Data Columns
        Set<TrainingInstitution> trainingInstitutions = TrainingFacade.trainingInstitutionService.findAll();
        for (TrainingInstitution trainingInstitution : trainingInstitutions) {
            addItem(new Object[]{trainingInstitution.getTrainingInstitution(),
                    contactNumber(trainingInstitution.getLocationContactId()),
                    postalAddress(trainingInstitution.getLocationContactId()),
                    physicalAddress(trainingInstitution.getLocationContactId()),
                    postalCode(trainingInstitution.getLocationContactId()),
                    cityName(trainingInstitution.getCityId())
            }, trainingInstitution.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }

    private String cityName(String cityId) {
        Location city = LocationFacade.locationService.findById(cityId);
        return city.getName();
    }

    private String postalCode(String locationContactId) {
        LocationAddress address = LocationFacade.locationAddressService.findById(locationContactId);
        return address.getPostalCode();
    }

    private String physicalAddress(String locationContactId) {
        LocationAddress address = LocationFacade.locationAddressService.findById(locationContactId);

        return address.getPhysicalAddress();
    }

    private String postalAddress(String locationContactId) {
        LocationAddress address = LocationFacade.locationAddressService.findById(locationContactId);
        return address.getPostalAddress();
    }

    private Object contactNumber(String locationContactId) {
        LocationAddress address = LocationFacade.locationAddressService.findById(locationContactId);
        return address.getContactNumber();
    }
}