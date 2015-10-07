package hashwork.domain.office;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BONGANI
 */
public class Department implements Serializable{
    private String id;
    private String name;
    private String description;
    private boolean active;
    private Date dateEstablished;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    private Department() {
    }

    private Department(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.active = builder.active;
        this.dateEstablished = builder.dateEstablished;
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private boolean active;
        private Date dateEstablished;

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

        public Builder active(boolean value) {
            this.active = value;
            return this;
        }

        public Builder dateEstablished(Date value) {
            this.dateEstablished = value;
            return this;
        }


        public Builder copy(Department value) {
            this.id = value.id;
            this.name = value.name;
            this.description = value.description;
            this.active = value.active;
            this.dateEstablished = value.dateEstablished;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}