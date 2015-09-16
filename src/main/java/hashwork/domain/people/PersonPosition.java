package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonPosition implements Serializable {
    private String id;
    private String personId;
    private String positionId;
    private Date startDate;
    private Date endDate;
    private String statusId;
    private BigDecimal salary;
    private String currencyId;
    private Date salaryDate;
    private String changeReasonId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPositionId() {
        return positionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatusId() {
        return statusId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public String getChangeReasonId() {
        return changeReasonId;
    }
    
    
    
    private PersonPosition()
    {
    
    }

         public PersonPosition(Builder builder){
            this.id =  builder.id;
            this.personId = builder.personId;
            this.positionId = builder.positionId;
            this.startDate = builder.startDate;
            this.statusId = builder.statusId;
            this.salary = builder.salary;
            this.currencyId = builder.currencyId;
            this.salaryDate = builder.salaryDate;
            this.changeReasonId = builder.changeReasonId;

        }
        public static class Builder{
            private String id;
            private String personId;
            private String positionId;
            private Date startDate;
            private Date endDate;
            private String statusId;
            private BigDecimal salary;
            private String currencyId;
            private Date salaryDate;
            private String changeReasonId;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder positionId(String value){
            this.positionId = value;
            return this;
        }
        public Builder startDate(Date value){
            this.startDate = value;
            return this;
        }
        public Builder endDate(Date value){
            this.endDate = value;
            return this;
        }

        public Builder statusId(String value){
            this.statusId = value;
            return this;
        }

        public Builder currencyId(String value){
            this.currencyId = value;
            return this;
        }
        public Builder salary(BigDecimal value){
            this.salary = value;
            return this;
        }
        public Builder salaryDate(Date value){
            this.salaryDate = value;
            return this;
        }
        public Builder changeReasonId(String value){
            this.changeReasonId = value;
            return this;
        }

        public Builder copy(PersonPosition value){

            this.id =  value.id;
            this.personId = value.personId;
            this.positionId = value.positionId;
            this.startDate = value.startDate;
            this.statusId = value.statusId;
            this.salary = value.salary;
            this.currencyId = value.currencyId;
            this.salaryDate = value.salaryDate;
            this.changeReasonId = value.changeReasonId;
            return this;
        }

        public PersonPosition build(){
            return new PersonPosition(this);
        }
    }
        
    public static Builder builder() {
        return new Builder();
    }

}


