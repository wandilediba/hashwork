package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class MedicalAidListModel implements Serializable {    
    private String medicalAidType;
    private String description;
    private BigDecimal monthlyContribution;

    public String getMedicalAidType() {
        return medicalAidType;
    }
    
    public void setMedicalAidType(String medicalAidType) {
        this.medicalAidType = medicalAidType;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }
    
     public void setMonthlyContribution(BigDecimal monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

}
