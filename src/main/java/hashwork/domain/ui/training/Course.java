package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Course  implements Serializable, Comparable<Course> {

    private static final long serialVersionUID = 1L;
    private String id;
    private String courseName;
    private String courseCategoryId;
    private String courseTopic;
    private String institutionNameId;

    private String courseStatusId;
    private String courseObjective;
    private int creditHours;
    private List<String> courseCompetenciesId;

    @Override
    public int compareTo(Course o) {
        return courseName.compareTo(o.courseName);
    }
}

