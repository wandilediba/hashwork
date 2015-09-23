package hashwork.client.content.system.utilities.model;

import java.io.Serializable;

/**
 * Created by bulelani on 2015/09/19.
 */
public class FunderModel implements Serializable {

    private String id;
    private String trainingFunderName;
    private String costCenter;
    private String cityId;
    private String LocationContactId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingFunderName() {
        return trainingFunderName;
    }

    public void setTrainingFunderName(String trainingFunderName) {
        this.trainingFunderName = trainingFunderName;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getLocationContactId() {
        return LocationContactId;
    }

    public void setLocationContactId(String locationContactId) {
        LocationContactId = locationContactId;
    }
}
