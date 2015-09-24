package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonEmploymentHistory implements Serializable {
    private String id;
    private String personId;
    private String companyName;
    private String companyAddress;
    private String companyTelephone;
    private String applicatSupervisor;
    private Boolean contactSupervisor;
    private String reasonsForLeaving;
    private Date startDate;
    private Date endDate;
    private BigDecimal startingSalary;
    private BigDecimal endingSalary;
    private String currencyId;
    private String jobResponsibility;
    private String jobId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public String getApplicatSupervisor() {
        return applicatSupervisor;
    }

    public Boolean getContactSupervisor() {
        return contactSupervisor;
    }

    public String getReasonsForLeaving() {
        return reasonsForLeaving;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BigDecimal getStartingSalary() {
        return startingSalary;
    }

    public BigDecimal getEndingSalary() {
        return endingSalary;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getJobResponsibility() {
        return jobResponsibility;
    }

    public String getJobId() {
        return jobId;
    }

    
     private PersonEmploymentHistory()
    {
    
    }
        public PersonEmploymentHistory(Builder builder){
        this.id =  builder.id;
        this.personId = builder.personId;
        this.companyName = builder.companyName;
        this.companyAddress = builder.companyAddress;
        this.companyTelephone = builder.companyTelephone;
        this.applicatSupervisor = builder.applicatSupervisor;
        this.contactSupervisor = builder.contactSupervisor;
        this.reasonsForLeaving = builder.reasonsForLeaving;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.startingSalary = builder.startingSalary;
        this.endingSalary = builder.endingSalary;
        this.currencyId = builder.currencyId;
        this.jobResponsibility = builder.jobResponsibility;
        this.jobId = builder.jobId;

        }
        public static class Builder{
           
        private String id;
        private String personId;
        private String companyName;
        private String companyAddress;
        private String companyTelephone;
        private String applicatSupervisor;
        private Boolean contactSupervisor;
        private String reasonsForLeaving;
        private Date startDate;
        private Date endDate;
        private BigDecimal startingSalary;
        private BigDecimal endingSalary;
        private String currencyId;
        private String jobResponsibility;
        private String jobId;

            public Builder id(String value){
            this.id = value;
            return this;
        }
            public Builder personId(String value){
            this.personId = value;
            return this;
        }
            public Builder companyName(String value){
            this.companyName = value;
            return this;
        }
            public Builder companyAddress(String value){
            this.companyAddress = value;
            return this;
        }
            public Builder companyTelephone(String value){
            this.companyTelephone = value;
            return this;
        }
            public Builder applicatSupervisor(String value){
            this.applicatSupervisor = value;
            return this;
        }
            public Builder contactSupervisor(Boolean value){
            this.contactSupervisor = value;
            return this;
        }
            public Builder reasonsForLeaving(String value){
            this.reasonsForLeaving = value;
            return this;
        }         
            public Builder startDate(Date date){
            this.startDate = date;
            return this;
        }         
            public Builder endDate(Date date){
            this.endDate = date;
            return this;
        }         
            public Builder startingSalary(BigDecimal value){
            this.startingSalary = value;
            return this;
        }         
          public Builder endingSalary(BigDecimal value){
            this.endingSalary = value;
            return this;
        }
            public Builder currencyId(String value){
            this.currencyId = value;
            return this;
        }
            public Builder jobResponsibility(String value){
            this.jobResponsibility = value;
            return this;
        }
            public Builder jobId(String value){
            this.jobId = value;
            return this;

        }
         
        public Builder copy(PersonEmploymentHistory value){

            this.id =  value.id;
            this.personId = value.personId;
            this.companyName = value.companyName;
            this.companyAddress = value.companyAddress;
            this.companyTelephone = value.companyTelephone;
            this.contactSupervisor = value.contactSupervisor;
            this.reasonsForLeaving = value.reasonsForLeaving;
            this.startDate = value.startDate;
            this.endDate = value.endDate;
            this.startingSalary = value.startingSalary;
            this.endingSalary = value.endingSalary;
            this.jobResponsibility = value.jobResponsibility;
            this.currencyId = value.currencyId;
            this.jobId = value.jobId;
            return this;
        }

        public PersonEmploymentHistory build(){
            return new PersonEmploymentHistory(this);

        }
    }

    public static Builder builder() {
        return new Builder();
    }
    
}
