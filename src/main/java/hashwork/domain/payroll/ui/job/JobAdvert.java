package hashwork.domain.payroll.ui.job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class JobAdvert implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Id;
    private String jobId;
    private Date start;
    private Date closingDate;
    private String description;
    private String active;
    private List<String> applicantsIds;

    public String getId() {
        return Id;
    }

    public String getJobId() {
        return jobId;
    }

    public Date getStart() {
        return start;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public String getDescription() {
        return description;
    }

    public String getActive() {
        return active;
    }

    public List<String> getApplicantsIds() {
        return applicantsIds;
    }

    private JobAdvert(){}
    private JobAdvert(Builder builder){
        this.Id = builder.Id;
        this.jobId = builder.jobId;
        this.start = builder.start;
        this.closingDate = builder.closingDate;
        this.description = builder.description;
        this.active = builder.active;
        this.applicantsIds = builder.applicantsIds;
    }

    public static class Builder{
        private String Id;
        private String jobId;
        private Date start;
        private Date closingDate;
        private String description;
        private String active;
        private List<String> applicantsIds;

        public Builder Id(String value){
            this.Id = value;
            return this;
        }
        public Builder jobId(String value){
            this.jobId = value;
            return this;
        }
        public Builder start(Date value){
            this.start = value;
            return this;
        }
        public Builder closingDate(Date value){
            this.closingDate = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder active(String value){
            this.active = value;
            return this;
        }
        public Builder applicantsIds(List<String> value){
            this.applicantsIds = value;
            return this;
        }

        public Builder copy(JobAdvert value) {
            this.Id = value.Id;
            this.jobId = value.jobId;
            this.start = value.start;
            this.closingDate = value.closingDate;
            this.description = value.description;
            this.active = value.active;
            this.applicantsIds = value.applicantsIds;

            return this;
        }

        public JobAdvert build(){
            return new JobAdvert(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobAdvert)) return false;

        JobAdvert jobAdvert = (JobAdvert) o;

        if (getId() != null ? !getId().equals(jobAdvert.getId()) : jobAdvert.getId() != null) return false;
        if (getJobId() != null ? !getJobId().equals(jobAdvert.getJobId()) : jobAdvert.getJobId() != null) return false;
        if (getStart() != null ? !getStart().equals(jobAdvert.getStart()) : jobAdvert.getStart() != null) return false;
        if (getClosingDate() != null ? !getClosingDate().equals(jobAdvert.getClosingDate()) : jobAdvert.getClosingDate() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(jobAdvert.getDescription()) : jobAdvert.getDescription() != null)
            return false;
        if (getActive() != null ? !getActive().equals(jobAdvert.getActive()) : jobAdvert.getActive() != null)
            return false;
        return !(getApplicantsIds() != null ? !getApplicantsIds().equals(jobAdvert.getApplicantsIds()) : jobAdvert.getApplicantsIds() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getJobId() != null ? getJobId().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getClosingDate() != null ? getClosingDate().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getActive() != null ? getActive().hashCode() : 0);
        result = 31 * result + (getApplicantsIds() != null ? getApplicantsIds().hashCode() : 0);
        return result;
    }
}
