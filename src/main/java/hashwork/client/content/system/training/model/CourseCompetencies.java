package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CourseCompetencies implements Serializable {
    private String id;
    private String courseId;
    private String  competencyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCompetencyId() {
        return competencyId;
    }

    public void setCompetencyId(String competencyId) {
        this.competencyId = competencyId;
    }
}
