package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.Location;

import java.util.List;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationFactory {
    public static Location getLocation(String name,
                                       String code,
                                       String latitude,
                                       String longitude,
                                       String locationTypeId,
                                       List<String> childrenIds,
                                       String parentId) {
        Location location = new Location.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name)
                .code(code)
                .latitude(latitude)
                .longitude(longitude)
                .locationTypeId(locationTypeId)
                .childrenIds(childrenIds)
                .parentId(parentId)
                .build();
        return location;
    }
}
