package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class TrainingInstitutionTrainer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String qualification;


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getQualification() {
        return qualification;
    }


    public TrainingInstitutionTrainer(){}


}
