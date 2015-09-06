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

    private RegistrationBody(){

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
            return  this;
        }
        public Builder name(String value){
            this.id = value;
            return  this;
        }
        public Builder description(String value){
            this.description = value;
            return  this;
        }
        public Builder coreActivity(String value){
            this.coreActivity = value;
            return  this;
        }
        public Builder active(String value){
            this.active = value;
            return  this;
        }
        public Builder asOfDate(Date value){
            this.asOfDate = value;
            return  this;
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

        public RegistrationBody build(){
            return new RegistrationBody(this);
        }
    }

    @Override
    public String toString() {
        return "RegistrationBody{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coreActivity='" + coreActivity + '\'' +
                ", active='" + active + '\'' +
                ", asOfDate=" + asOfDate +
                '}';
    }

}
