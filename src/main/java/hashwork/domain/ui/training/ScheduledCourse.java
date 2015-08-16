package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.*;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private int courseCapacity;
    private int numOfStuds;
    private Date startDate;
    private Date endDate;
    private Date dateRequested;
    private String courseNameId;
    private String venue;
    private String status;
    private List<String> courseRequestors = new ArrayList<>();
    private List<String> courseFundersIds = new ArrayList<>();
    private Set<String> participants = new HashSet<>();
}
