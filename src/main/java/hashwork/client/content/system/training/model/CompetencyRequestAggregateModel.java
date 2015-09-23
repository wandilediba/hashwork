package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyRequestAggregateModel implements Serializable {
    private String id;
    private String competencyName;
    private String status;
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
