package hashwork.client.content.system.education.model;

import hashwork.domain.ui.education.EducationType;

/**
 * Created by hashcode on 2015/09/05.
 */
public class EducationTypeModel {

    private static final long serialVersionUID = 1L;
    private String id;
    //"Competent," "Not Competent" and "Not Assessed"
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

