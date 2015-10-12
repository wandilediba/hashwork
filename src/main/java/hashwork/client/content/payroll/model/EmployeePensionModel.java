package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeePensionModel implements Serializable {
   
    private String personId;
    private Date startDate;
    private String pensionCode;
    private BigDecimal goalAmount;
    private BigDecimal lastContribution;
    private Date lastContributionDate;
    private BigDecimal contributionToDate;

    public String getPersonId() {
        return personId;
    }
    
    public void setPersonId(String personId) {
        this.personId =  personId;
    }

    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPensionCode() {
        return pensionCode;
    }
   
    public void setPensionCode(String pensionCode) {
        this.pensionCode = pensionCode;
    }    

    public BigDecimal getGoalAmount() {
        return goalAmount;
    }
    
     public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
    }

    public BigDecimal getLastContribution() {
        return lastContribution;
    }
    
     public void setLastContribution(BigDecimal lastContribution) {
        this.lastContribution = lastContribution;
    }

    public Date getLastContributionDate() {
        return lastContributionDate;
    }
    
     public void setLastContributionDate(Date lastContributionDate) {
        this.lastContributionDate =  lastContributionDate;
    }

    public BigDecimal getContributionToDate() {
        return contributionToDate;
    }
    
    public void setContributionToDate(BigDecimal contributionToDate) {
        this.contributionToDate = contributionToDate;
    }

    
}
