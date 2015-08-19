package hashwork.domain.payroll.ui;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class TaxCodes implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String code;
    private String codeType;
    private String codeDecription;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCodeType() {
        return codeType;
    }

    public String getCodeDecription() {
        return codeDecription;
    }

    private TaxCodes() {
    }

    private TaxCodes(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.codeType = builder.codeType;
        this.codeDecription = builder.codeDecription;
    }

    public static class Builder {
        private Long id;
        private String code;
        private String codeType;
        private String codeDecription;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder code(String value) {
            this.code = value;
            return this;
        }

        public Builder codeType(String value) {
            this.codeType = value;
            return this;
        }

        public Builder codeDecription(String value) {
            this.codeDecription = value;
            return this;
        }

        public Builder copy(TaxCodes value) {
            this.id = value.id;
            this.code = value.code;
            this.codeType = value.codeType;
            this.codeDecription = value.codeDecription;
            return this;
        }

        public TaxCodes build(){
            return new TaxCodes(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxCodes)) return false;

        TaxCodes taxCodes = (TaxCodes) o;

        if (id != null ? !id.equals(taxCodes.id) : taxCodes.id != null) return false;
        if (code != null ? !code.equals(taxCodes.code) : taxCodes.code != null) return false;
        if (codeType != null ? !codeType.equals(taxCodes.codeType) : taxCodes.codeType != null) return false;
        return !(codeDecription != null ? !codeDecription.equals(taxCodes.codeDecription) : taxCodes.codeDecription != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (codeType != null ? codeType.hashCode() : 0);
        result = 31 * result + (codeDecription != null ? codeDecription.hashCode() : 0);
        return result;
    }
}