package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by zamzam on 2015/10/02.
 */
public class EarningsListModel implements Serializable {
    private String earningsType;
    private String earningsDesc;

    public String getEarningsType() {
        return earningsType;
    }

    public void setEarningsType(String earningsType) {
        this.earningsType = earningsType;
    }

    public String getEarningsDesc() {
        return earningsDesc;
    }

    public void setEarningsDesc(String earningsDesc) {
        this.earningsDesc = earningsDesc;
    }
}
