package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class TrainingInstitution implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String trainingInstitution;
    private String cityId;
    private String locationContact;

    public void setId(String id) {
        this.id = id;
    }

    public void setTrainingInstitution(String trainingInstitution) {
        this.trainingInstitution = trainingInstitution;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setLocationContact(String locationContact) {
        this.locationContact = locationContact;
    }

    public String getId() {
        return id;
    }

    public String getTrainingInstitution() {
        return trainingInstitution;
    }

    public String getCityId() {
        return cityId;
    }

    public String getLocationContact() {
        return locationContact;
    }

    public TrainingInstitution(){}


}
