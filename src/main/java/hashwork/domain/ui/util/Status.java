package hashwork.domain.ui.util;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String statusType;
    private String statusValues;

    public String getId() {
        return id;
    }

    public String getStatusType() {
        return statusType;
    }

    public String getStatusValues() {
        return statusValues;
    }

    private Status(Builder builder) {
        this.id = builder.id;
        this.statusType = builder.statusType;
        this.statusValues = builder.statusValues;

    }


    public static class Builder {
        private String id;
        private String statusType;
        private String statusValues;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder statusType(String value) {
            this.statusType = value;
            return this;
        }

        public Builder statusValue(String value) {
            this.statusValues = value;
            return this;
        }

        public Builder copy(Status value) {
            this.id = value.id;
            this.statusType = value.statusType;
            this.statusValues = value.statusValues;

            return this;
        }

        public Status build() {
            return new Status(this);
        }

    }


}
