package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.LocationType;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationTypeFactory {
    public static LocationType getLocationType(String name, String code) {
        LocationType locationType = new LocationType.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name)
                .code(code)
                .build();
        return locationType;
    }
}
