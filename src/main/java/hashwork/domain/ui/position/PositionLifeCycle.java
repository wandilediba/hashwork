package hashwork.domain.ui.position;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionLifeCycle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Id;
    private String positionId;
    private Date dateofAction;
    private String status;
}
