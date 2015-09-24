package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseRequest implements Serializable {

    private String id;
    private String requestName;

    private List<String> requestorsIds; //People Who requested Course

    private List<String> competenciesIds;
    private Date prefferedStart;
    private Date preferredEnd;
    private Date requestedDate;
    private List<String> funderIds;
    private List<String> trainingInstitutionsId;
    private String status;
    // REQUESTED, //CREATED  //SCHEDULED


    public String getId() {
        return id;
    }

    public String getRequestName() {
        return requestName;
    }

    public List<String> getRequestorsIds() {
        return requestorsIds;
    }

    public List<String> getCompetenciesIds() {
        return competenciesIds;
    }

    public Date getPrefferedStart() {
        return prefferedStart;
    }

    public Date getPreferredEnd() {
        return preferredEnd;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public List<String> getFunderIds() {
        return funderIds;
    }

    public List<String> getTrainingInstitutionsId() {
        return trainingInstitutionsId;
    }

    public String getStatus() {
        return status;
    }

    private CourseRequest(){}

    private CourseRequest(Builder builder) {
        this.id = builder.id;
        this.requestName = builder.requestName;
        this.requestorsIds = builder.requestorsIds;
        this.competenciesIds = builder.competenciesIds;
        this.prefferedStart = builder.prefferedStart;
        this.preferredEnd = builder.preferredEnd;
        this.requestedDate = builder.preferredEnd;
        this.funderIds = builder.funderIds;
        this.trainingInstitutionsId = builder.trainingInstitutionsId;
        this.status  = builder.status;
    }

    public static class Builder{

        private String id;
        private String requestName;
        private List<String> requestorsIds;
        private List<String> competenciesIds;
        private Date prefferedStart;
        private Date preferredEnd;
        private Date requestedDate;
        private List<String> funderIds;
        private List<String> trainingInstitutionsId;
        private String status;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder requestName(String value){
            this.requestName = value;
            return this;
        }

        public Builder requestorsIds(List<String> value){
            this.requestorsIds = value;
            return this;
        }

        public Builder competenciesIds(List<String> value){
            this.competenciesIds = value;
            return this;
        }

        public Builder prefferedStart(Date value){
            this.prefferedStart = value;
            return this;
        }

        public Builder prefferedEnd(Date value){
            this.preferredEnd = value;
            return this;
        }

        public Builder requestedDate(Date value){
            this.requestedDate = value;
            return this;
        }

        public Builder funderIds(List<String> value){
            this.funderIds = value;
            return this;
        }

        public Builder trainingInstitutionsId(List<String> value){
            this.trainingInstitutionsId = value;
            return this;
        }

        public Builder status(String value){
            this.status = value;
            return this;
        }

        public Builder copy(CourseRequest value) {
            this.id = value.id;
            this.requestName = value.requestName;
            this.requestorsIds = value.requestorsIds;
            this.competenciesIds = value.competenciesIds;
            this.prefferedStart = value.prefferedStart;
            this.preferredEnd = value.preferredEnd;
            this.requestedDate = value.requestedDate;
            this.funderIds = value.funderIds;
            this.trainingInstitutionsId = value.trainingInstitutionsId;
            this.status = value.status;

            return this;

        }


        public CourseRequest build(){
            return new CourseRequest(this);
        }



    }
}
