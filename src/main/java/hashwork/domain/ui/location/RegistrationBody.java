package hashwork.domain.ui.location;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class RegistrationBody implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String description;
    private String coreActivity;
    private String active;
    private Date asOfDate;
}
