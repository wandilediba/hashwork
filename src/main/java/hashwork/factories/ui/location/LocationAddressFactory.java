package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.LocationAddress;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationAddressFactory {
    public static LocationAddress getLocationAddress(String postalAddress,
                                                     String physicalAddress,
                                                     String contactNumber,
                                                     String postalCode,
                                                     String emailAddress) {
        LocationAddress locationAddress = new LocationAddress.Builder()
                .postalAddress(postalAddress)
                .physicalAddress(physicalAddress)
                .contactNumber(contactNumber)
                .postalCode(postalCode)
                .emailAddress(emailAddress)
                .build();
        return locationAddress;
    }
}
