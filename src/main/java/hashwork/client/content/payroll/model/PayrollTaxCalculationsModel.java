package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by zamzam on 2015/10/02.
 */
public class PayrollTaxCalculationsModel implements Serializable {
    private String taxCodesId;

    public String getTaxCodesId() {
        return taxCodesId;
    }

    public void setTaxCodesId(String taxCodesId) {
        this.taxCodesId = taxCodesId;
    }
}
