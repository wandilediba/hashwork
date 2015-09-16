package hashwork.services.ui.location;

import hashwork.domain.ui.location.Location;
import hashwork.services.Services;

/**
 * Created by garran on 2015/09/06.
 */
public interface LocationService extends Services<Location, String> {
    boolean hasChildren(String id);

    long numberofChildred(String id);
}
