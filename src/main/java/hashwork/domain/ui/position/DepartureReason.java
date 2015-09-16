package hashwork.domain.ui.position;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class DepartureReason implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String reasonName;
    private String description;


    public DepartureReason(){}

    public String getId() {
        return id;
    }

    public String getReasonName() {
        return reasonName;
    }

    public String getDescription() {
        return description;
    }

    private DepartureReason(Builder builder) {
        this.id = builder.id;
        this.reasonName = builder.reasonName;
        this.description = builder.description;

    }
    public static class Builder {

        private String id;
        private String reasonName;
        private String description;


        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder reasonName(String value) {

            this.reasonName = value;
            return this;
        }

        public Builder description(String value) {

            this.description = value;
            return this;
        }

        public Builder copy(DepartureReason value) {
            this.id = value.id;
            this.reasonName = value.reasonName;
            return this;


        }

        public DepartureReason build(){
            return new DepartureReason(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartureReason that = (DepartureReason) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reasonName != null ? !reasonName.equals(that.reasonName) : that.reasonName != null) return false;
        return !(description != null ? !description.equals(that.description) : that.description != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reasonName != null ? reasonName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }



}
