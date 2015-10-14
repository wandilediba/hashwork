package hashwork.client.content.training.institutions.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/10/10.
 */
public class TrainingInstitutionTrainerModel implements Serializable {
    private String title;
    private String firstName;
    private String lastName;
    private String qualification;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
