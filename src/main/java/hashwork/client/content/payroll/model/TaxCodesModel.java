package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by zamzam on 2015/10/02.
 */
public class TaxCodesModel implements Serializable {
    private String code;
    private String codeType;
    private String codeDecription;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeDecription() {
        return codeDecription;
    }

    public void setCodeDecription(String codeDecription) {
        this.codeDecription = codeDecription;
    }
}
