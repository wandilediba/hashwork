package hashwork.client.content.system.education.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */


public class DegreeModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String studyField;
    private String educationTypeId;
    //Bachelor , Diploma , Masters , PhD
    private String degreeName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getStudyField() {
        return studyField;
    }

    public String getEducationTypeId() {
        return educationTypeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    public void setEducationTypeId(String educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}