package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CompetencyEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    //Attended , Competetent ..
    private String compTypeName;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompTypeName() {
        return compTypeName;
    }

    public void setCompTypeName(String compTypeName) {
        this.compTypeName = compTypeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
