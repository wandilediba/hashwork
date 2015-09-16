package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class MaritalStatusList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String statusName;

    public String getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

    private MaritalStatusList(){

    }
    private MaritalStatusList(Builder builder){
        this.id = builder.id;
        this.statusName = builder.statusName;
    }
    public static class Builder{
        private String id;
        private String statusName;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder statusName(String value){
            this.statusName = value;
            return this;
        }

        public Builder copy(MaritalStatusList value) {
            this.id = value.id;
            this.statusName = value.statusName;
            return this;
        }

        public MaritalStatusList build() {
            return new MaritalStatusList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaritalStatusList)) return false;

        MaritalStatusList that = (MaritalStatusList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getStatusName() != null ? !getStatusName().equals(that.getStatusName()) : that.getStatusName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStatusName() != null ? getStatusName().hashCode() : 0);
        return result;
    }
}
