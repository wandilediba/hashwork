package hashwork.domain.office;

import java.io.Serializable;

/**
 * @author BONGANI
 */
public class OfficeType implements Serializable{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
        
    private OfficeType() {
    }
    private OfficeType(Builder builder){
           this.id = builder.id;
           this.name = builder.name;
       }

    public static class Builder{
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

        public Builder copy(OfficeType value) {
            this.id = value.id;
            this.name = value.name;
            return this;
        }

        public OfficeType build() {
            return new OfficeType(this);
        }
    }
}
