package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class LocationFactory {
    public static Location getLocation(Map<String,String> values,
                                       List<String> childrenId){
        Location location = new Location
                .Builder()
                .id(KeyGenerator.getEntityId())
                .name(values.get("name"))
                .code(values.get("code"))
                .latitude(values.get("latitude"))
                .longitude(values.get("longitude"))
                .locationTypeId(values.get("locationTypeId"))
              //  .childrenIds.containsAll(childrenId)
                .parentId(values.get("parentId")).build();
        return location;

    }
}
