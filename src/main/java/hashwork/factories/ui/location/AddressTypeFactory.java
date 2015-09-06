package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.AddressType;

import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class AddressTypeFactory {
    public static AddressType getAddressType(Map<String,String> values){
        AddressType addressType = new AddressType
                .Builder()
                .id(KeyGenerator.getEntityId())
                .addressTypeName(values.get("addressTypeName")).build();
        return addressType;
    }
}
