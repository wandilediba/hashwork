package hashwork.domain.ui.position;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    //Full Time, PartTime, Causal , Hourly
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private PositionType(Builder builder){

        this.id = builder.id;
        this.name = builder.name;
    }

    public static  class Builder{
        private String id;
        private String name;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder name(String value){

            this.name = value;
            return this;
        }

        public Builder copy(PositionType value) {
            this.id = value.id;
            this.name = value.name;
            return this;
        }

        public PositionType build(){
            return new PositionType(this);
        }


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionType that = (PositionType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
