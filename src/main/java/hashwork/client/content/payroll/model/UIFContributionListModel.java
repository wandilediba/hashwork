package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class UIFContributionListModel implements Serializable {
    private String code;
    private BigDecimal uifPercentContribution;
   
    public String getCode() {
        return code;
    }
    
     public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getUifPercentContribution() {
        return uifPercentContribution;
    }
    
     public void setUifPercentContribution(BigDecimal uifPercentContribution) {
        this.uifPercentContribution = uifPercentContribution;
    }

}
