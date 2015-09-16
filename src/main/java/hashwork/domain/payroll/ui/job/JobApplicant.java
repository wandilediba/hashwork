package hashwork.domain.payroll.ui.job;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class JobApplicant implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String applicantId;

    public String getId() {
        return id;
    }

    public String getApplicantId() {
        return applicantId;
    }

    private JobApplicant(){

    }
    private JobApplicant(Builder builder){
        this.id = builder.id;
        this.applicantId = builder.applicantId;
    }

    public static class Builder{
        private String id;
        private String applicantId;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder applicationId(String value){
            this.applicantId = value;
            return  this;
        }

        public Builder copy(JobApplicant value) {
            this.id = value.id;
            this.applicantId = value.applicantId;

            return this;
        }

        public JobApplicant build(){
            return new JobApplicant(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobApplicant)) return false;

        JobApplicant that = (JobApplicant) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getApplicantId() != null ? !getApplicantId().equals(that.getApplicantId()) : that.getApplicantId() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getApplicantId() != null ? getApplicantId().hashCode() : 0);
        return result;
    }
}
