package hashwork.client.content.system.training.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zenzile on 2015/09/19.
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(String courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseTopic() {
        return courseTopic;
    }

    public void setCourseTopic(String courseTopic) {
        this.courseTopic = courseTopic;
    }

    public String getInstitutionNameId() {
        return institutionNameId;
    }

    public void setInstitutionNameId(String institutionNameId) {
        this.institutionNameId = institutionNameId;
    }

    public String getCourseStatusId() {
        return courseStatusId;
    }

    public void setCourseStatusId(String courseStatusId) {
        this.courseStatusId = courseStatusId;
    }

    public String getCourseObjective() {
        return courseObjective;
    }

    public void setCourseObjective(String courseObjective) {
        this.courseObjective = courseObjective;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public List<String> getCourseCompetenciesId() {
        return courseCompetenciesId;
    }

    public void setCourseCompetenciesId(List<String> courseCompetenciesId) {
        this.courseCompetenciesId = courseCompetenciesId;
    }

    @Override
    public int compareTo(Course o) {
        return 0;
    }
}

