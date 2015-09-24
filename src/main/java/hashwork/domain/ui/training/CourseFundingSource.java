package hashwork.domain.ui.training;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseFundingSource implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;


    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getFunderId() {
        return funderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public CourseFundingSource(){}

    private CourseFundingSource(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.funderId = builder.funderId;
        this.courseId = builder.courseId;
        this.currencyId = builder.currencyId;
    }

    public static class Builder{
        private String id;
        private String courseId;
        private String funderId;
        private BigDecimal amount;
        private String currencyId;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder courseId(String value){
            this.courseId = value;
            return this;
        }

        public Builder funderid(String value){
            this.funderId = value;
            return this;
        }

        public Builder amount(BigDecimal value){
            this.amount = value;
            return this;
        }

        public Builder currencyId(String value){
            this.currencyId = value;
            return this;
        }

        public Builder copy(CourseFundingSource value) {
            this.id = value.id;
            this.funderId = value.funderId;
            this.currencyId = value.currencyId;
            this.amount = value.amount;
            this.courseId = value.courseId;

            return this;

        }
        public CourseFundingSource build(){
            return new CourseFundingSource(this);
        }

    }
}
