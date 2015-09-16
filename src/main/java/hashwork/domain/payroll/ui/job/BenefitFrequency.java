package hashwork.domain.payroll.ui.job;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class BenefitFrequency implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    //Anual , Weekly, Monthly etc
    private String frequency;


    public String getId() {
        return id;
    }

    public String getBenefitFrequency() {
        return frequency;
    }

    private BenefitFrequency() {

    }

    private BenefitFrequency(Builder builder) {
        this.id = builder.id;
        this.frequency = builder.frequency;
    }

    public static class Builder {
        private String id;
        private String frequency;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder frequency(String value) {
            this.frequency = value;
            return this;
        }


        public Builder copy(BenefitFrequency value) {
            this.id = value.id;
            this.frequency = value.frequency;

            return this;
        }

        public BenefitFrequency build() {
            return new BenefitFrequency(this);
        }
    }

    @Override
    public String toString() {
        return "BenefitFrequency{" +
                "id=" + id +
                ", frequency='" + frequency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BenefitFrequency)) return false;

        BenefitFrequency that = (BenefitFrequency) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getBenefitFrequency() != null ? !getBenefitFrequency().equals(that.getBenefitFrequency()) : that.getBenefitFrequency() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBenefitFrequency() != null ? getBenefitFrequency().hashCode() : 0);
        return result;
    }


}
