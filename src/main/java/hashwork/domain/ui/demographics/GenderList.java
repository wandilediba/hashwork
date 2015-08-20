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
}
