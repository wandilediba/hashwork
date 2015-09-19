package hashwork.client.content.system.education.model;

import hashwork.domain.ui.education.CompetencyType;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */


public class CompetencyTypeModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    // Computer Skills, Client Interaction and Accounting based on Company Competency Model
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
