package hashwork.client.content.system.training.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CourseFundingSource implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getFunderId() {
        return funderId;
    }

    public void setFunderId(String funderId) {
        this.funderId = funderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
}
