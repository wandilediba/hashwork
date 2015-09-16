package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class GenderList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String gender;

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    private GenderList(Builder builder){
        this.id = builder.id;
        this.gender = builder.gender;
    }

    public static class Builder{
        private String id;
        private String gender;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder copy(GenderList value) {
            this.id = value.id;
            this.gender = value.gender;
            return this;
        }

        public GenderList build(){
            return new GenderList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenderList)) return false;

        GenderList that = (GenderList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getGender() != null ? !getGender().equals(that.getGender()) : that.getGender() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenderList{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
