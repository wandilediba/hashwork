package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.LocationAddress;

import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class LocationAddressFactory {
    public static LocationAddress getLocationAddress(Map<String,String> values){
        LocationAddress locationAddress = new LocationAddress
                .Builder()
                .id(KeyGenerator.getEntityId())
                .postalAddress(values.get("postalAddress"))
                .physicalAddress(values.get("physicalAddress"))
                .contactNumber(values.get("contactNumber"))
                .postalAddress(values.get("postalAddress"))
                .emailAddress(values.get("emailAddress")).build();
        return locationAddress;
    }
}
