package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeUIFContributionModel implements Serializable {
    private String personId;
    private String country;
    private BigDecimal contribution;
    private BigDecimal currentAmount;
    private Date lastContributionDate;
    
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country ;
    }

    public BigDecimal getContribution() {
        return contribution;
    }
    
     public void setContribution(BigDecimal contribution) {
        this.contribution = contribution;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }
    
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getLastContributionDate() {
        return lastContributionDate;
    }
    
    public void setLastContributionDate(Date lastContributionDate) {
        this.lastContributionDate = lastContributionDate;
    }
}
