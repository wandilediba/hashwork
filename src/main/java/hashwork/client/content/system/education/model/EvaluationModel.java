package hashwork.client.content.system.education.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */

public class EvaluationModel implements Serializable {

    private String id;
    //"Competent," "Not Competent" and "Not Assessed"
    private String name;

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