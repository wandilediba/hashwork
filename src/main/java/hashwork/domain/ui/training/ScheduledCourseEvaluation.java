package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseEvaluation implements Serializable {
    private String id;
    private String scheduledCourseId;
    private static final long serialVersionUID = 1L;
    private int  rating ;
    private String comments;

}
