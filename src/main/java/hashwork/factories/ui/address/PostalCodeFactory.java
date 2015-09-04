package hashwork.factories.ui.address;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.address.PostalCode;

/**
 * Created by garran on 2015/08/30.
 */
public class PostalCodeFactory {
    public static PostalCode getPostalCode(String postalCodes) {
        PostalCode postalCode = new PostalCode.Builder()
                .id(KeyGenerator.getEntityId())
                .postalCode(postalCodes).build();
        return postalCode;
    }
}
