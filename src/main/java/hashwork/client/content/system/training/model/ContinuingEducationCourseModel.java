package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class ContinuingEducationCourseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseName;
    private int creditHours;

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

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
}
