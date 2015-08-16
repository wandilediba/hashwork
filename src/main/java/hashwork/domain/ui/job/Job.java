package hashwork.domain.ui.job;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Job implements Serializable, Comparable<Job>{
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String code ;
    private String description;
    private String salaryGradeId;
    private String jobClassificationId;
    private List<String> positionIds;
    @Override
    public int compareTo(Job o) {
        return title.compareTo(o.title);
    }
}
