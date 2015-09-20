package hashwork.client.content.system.positions.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionTypeModel implements Serializable {

    //Full Time, PartTime, Causal , Hourly
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
