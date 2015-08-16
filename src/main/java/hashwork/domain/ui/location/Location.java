package hashwork.domain.ui.location;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String code;
    private String latitude;
    private String longitude;
    private LocationType locationType;
    private List<Location> children;
    private Location parent;
}
