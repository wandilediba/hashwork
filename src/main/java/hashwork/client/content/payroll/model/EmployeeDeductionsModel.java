package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeDeductionsModel implements Serializable {
  
    private String personId;
    private BigDecimal deductionAmt;
    private String deductionTypeDesc;

    public String getPersonId() {
        return personId;
    }
    
     public void setPersonId(String personId) {
        this.personId = personId;
    }

    public BigDecimal getDeductionAmt() {
        return deductionAmt;
    }
    
     public void setDeductionAmt(BigDecimal deductionAmt) {
        this.deductionAmt = deductionAmt;
    }

    public String getDeductionTypeDesc() {
        return deductionTypeDesc;
    }
    
    public void setDeductionTypeDesc(String deductionTypeDesc) {
        this.deductionTypeDesc = deductionTypeDesc ;
    }
      
}

