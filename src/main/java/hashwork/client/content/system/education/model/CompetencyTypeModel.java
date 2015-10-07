package hashwork.client.content.system.education.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */
public class CompetencyTypeModel implements Serializable{
    private static final long serialVersionUID = 1L;

    // Computer Skills, Client Interaction and Accounting based on Company Competeancy Model
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
