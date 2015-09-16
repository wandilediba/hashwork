package hashwork.domain.ui.location;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class RegistrationBody implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String description;
    private String coreActivity;
    private String active;
    private Date asOfDate;
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoreActivity() {
        return coreActivity;
    }

    public String getActive() {
        return active;
    }

    public Date getAsOfDate() {
        return asOfDate;
    }

    private RegistrationBody() {
    }

    private RegistrationBody(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.coreActivity = builder.coreActivity;
        this.active = builder.active;
        this.asOfDate = builder.asOfDate;

    }

    public static class Builder{
        private String id;
        private String name;
        private String description;
        private String coreActivity;
        private String active;
        private Date asOfDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder coreActivity(String value){
            this.coreActivity = value;
            return this;
        }
        public Builder active(String value){
            this.active = value;
            return this;
        }
        public Builder asOfDate(Date value){
            this.asOfDate = value;
            return this;
        }

        public Builder copy(RegistrationBody value) {
            this.id = value.id;
            this.name = value.name;
            this.description = value.description;
            this.coreActivity = value.coreActivity;
            this.active = value.active;
            this.asOfDate = value.asOfDate;
            return this;
        }

        public RegistrationBody build() {
            return new RegistrationBody(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationBody)) return false;

        RegistrationBody that = (RegistrationBody) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getCoreActivity() != null ? !getCoreActivity().equals(that.getCoreActivity()) : that.getCoreActivity() != null)
            return false;
        if (getActive() != null ? !getActive().equals(that.getActive()) : that.getActive() != null) return false;
        return !(getAsOfDate() != null ? !getAsOfDate().equals(that.getAsOfDate()) : that.getAsOfDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getCoreActivity() != null ? getCoreActivity().hashCode() : 0);
        result = 31 * result + (getActive() != null ? getActive().hashCode() : 0);
        result = 31 * result + (getAsOfDate() != null ? getAsOfDate().hashCode() : 0);
        return result;
    }
}
