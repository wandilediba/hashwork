package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.LocationType;

import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class LocationTypeFactory {
    public static LocationType getLocationType(Map<String, String> value){
        LocationType locationType = new LocationType
                .Builder()
                .id(KeyGenerator.getEntityId())
                .name(value.get("name"))
                .code(value.get("code")).build();
        return locationType;
    }
}
