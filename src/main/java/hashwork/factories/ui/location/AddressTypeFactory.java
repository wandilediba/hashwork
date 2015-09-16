package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.AddressType;

/**
 * Created by garran on 2015/09/06.
 */
public class AddressTypeFactory {
    public static AddressType getAddressType(String addressTypeName) {
        AddressType addressType = new AddressType.Builder()
                .id(KeyGenerator.getEntityId())
                .addressTypeName(addressTypeName).build();
        return addressType;
    }
}
