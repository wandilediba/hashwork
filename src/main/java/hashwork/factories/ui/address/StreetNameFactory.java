package hashwork.factories.ui.address;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.address.StreetName;

/**
 * Created by garran on 2015/08/30.
 */
public class StreetNameFactory {
    public static StreetName getLanguage(String streetNames) {
        StreetName streetName = new StreetName.Builder()
                .id(KeyGenerator.getEntityId())
                .streetName(streetNames).build();
        return streetName;
    }
}
