package hashwork.domain.ui.region;

import java.io.Serializable;

/**
 * Created by garran on 2015/08/31.
 */
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String province;

    public String getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    private Province(){}

    private Province(Builder builder){
        this.id = builder.id;
        this.province = builder.province;
    }

    public static class Builder{
        private String id;
        private String province;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder province(String value){
            this.province = value;
            return this;
        }

        public Builder copy(Province value) {
            this.id = value.id;
            this.province = value.province;
            return this;
        }

        public Province build() {
            return new Province(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;

        Province province1 = (Province) o;

        if (getId() != null ? !getId().equals(province1.getId()) : province1.getId() != null) return false;
        return !(getProvince() != null ? !getProvince().equals(province1.getProvince()) : province1.getProvince() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProvince() != null ? getProvince().hashCode() : 0);
        return result;
    }
}
