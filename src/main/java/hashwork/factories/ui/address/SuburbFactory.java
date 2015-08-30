package hashwork.factories.ui.address;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.address.Suburb;

/**
 * Created by garran on 2015/08/30.
 */
public class SuburbFactory {
    public static Suburb getSuburb(String suburbs) {
        Suburb suburb = new Suburb.Builder()
                .id(KeyGenerator.getEntityId())
                .suburb(suburbs).build();
        return suburb;
    }
}
