package hashwork.domain.ui.util;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class AccidentTypeList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String  name;
    private String description;


    private AccidentTypeList(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private AccidentTypeList(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;

    }

    public static class Builder {

        private String id;
        private String name;
        private String description;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder copy(AccidentTypeList value) {
            this.id = value.id;
            this.name = value.name;
            this.description = value.description;
            return this;
        }

        public AccidentTypeList build() {
            return new AccidentTypeList(this);
        }


    }
}
