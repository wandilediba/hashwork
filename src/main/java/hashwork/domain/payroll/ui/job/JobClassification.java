package hashwork.domain.payroll.ui.job;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class JobClassification implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String currentTitle;
    private String oldTitle;
    private String oldCode;
    private String currentCode;
    private String codeConversion;
    private String comment;

    public String getId() {
        return id;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public String getOldCode() {
        return oldCode;
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public String getCodeConversion() {
        return codeConversion;
    }

    public String getComment() {
        return comment;
    }

    private JobClassification(){

    }
    private JobClassification(Builder builder){
        this.id = builder.id;
        this.currentTitle = builder.currentTitle;
        this.oldTitle = builder.oldTitle;
        this.oldCode = builder.oldCode;
        this.currentCode = builder.currentCode;
        this.codeConversion = builder.codeConversion;
        this.comment = builder.comment;
    }

    public static class Builder{
        private String id;
        private String currentTitle;
        private String oldTitle;
        private String oldCode;
        private String currentCode;
        private String codeConversion;
        private String comment;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder currentTitle(String value){
            this.currentTitle = value;
            return  this;
        }
        public Builder oldTitle(String value){
            this.oldTitle = value;
            return  this;
        }
        public Builder oldCode(String value){
            this.oldCode = value;
            return  this;
        }
        public Builder currentCode(String value){
            this.currentCode = value;
            return  this;
        }
        public Builder codeConversion(String value){
            this.codeConversion = value;
            return  this;
        }
        public Builder comment(String value){
            this.comment = value;
            return  this;
        }

        public Builder copy(JobClassification value) {
            this.id = value.id;
            this.currentTitle = value.currentTitle;
            this.oldTitle = value.oldTitle;
            this.oldCode = value.oldCode;
            this.currentCode = value.currentCode;
            this.codeConversion = value.codeConversion;
            this.comment = value.comment;
            return this;
        }

        public JobClassification build(){
            return new JobClassification(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobClassification)) return false;

        JobClassification that = (JobClassification) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCurrentTitle() != null ? !getCurrentTitle().equals(that.getCurrentTitle()) : that.getCurrentTitle() != null)
            return false;
        if (getOldTitle() != null ? !getOldTitle().equals(that.getOldTitle()) : that.getOldTitle() != null)
            return false;
        if (getOldCode() != null ? !getOldCode().equals(that.getOldCode()) : that.getOldCode() != null) return false;
        if (getCurrentCode() != null ? !getCurrentCode().equals(that.getCurrentCode()) : that.getCurrentCode() != null)
            return false;
        if (getCodeConversion() != null ? !getCodeConversion().equals(that.getCodeConversion()) : that.getCodeConversion() != null)
            return false;
        return !(getComment() != null ? !getComment().equals(that.getComment()) : that.getComment() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCurrentTitle() != null ? getCurrentTitle().hashCode() : 0);
        result = 31 * result + (getOldTitle() != null ? getOldTitle().hashCode() : 0);
        result = 31 * result + (getOldCode() != null ? getOldCode().hashCode() : 0);
        result = 31 * result + (getCurrentCode() != null ? getCurrentCode().hashCode() : 0);
        result = 31 * result + (getCodeConversion() != null ? getCodeConversion().hashCode() : 0);
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        return result;
    }
}
