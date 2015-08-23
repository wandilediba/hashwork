package hashwork.domain.ui.position;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionLifeCycle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Id;
    private String positionId;
    private Date dateofAction;
    private String status;



public PositionLifeCycle(){}

    public static class Builder{
        private String id;
        private String positionId;
        private Date dateofAction;
        private String status;

        public Builder id(String value){
            this.id = value;
            return this;
        }


        public Builder positionId( String value){
            this.positionId = value;
            return this;
        }

        public Builder dateofAction(Date value){
            this.dateofAction = value;
            return this;
        }

        public Builder status( String value){
            this.status = value;
            return this;
        }

        public Builder copy(PositionLifeCycle value) {
            this.id = value.Id;
            this.dateofAction = value.dateofAction;
            this.status = value.status;
            this.positionId = value.positionId;
            return this;
        }
    }

    public String getId() {
        return Id;
    }

    public String getPositionId() {
        return positionId;
    }

    public Date getDateofAction() {
        return dateofAction;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionLifeCycle that = (PositionLifeCycle) o;

        if (!Id.equals(that.Id)) return false;
        if (!positionId.equals(that.positionId)) return false;
        if (!dateofAction.equals(that.dateofAction)) return false;
        return status.equals(that.status);

    }

    @Override
    public int hashCode() {
        int result = Id.hashCode();
        result = 31 * result + positionId.hashCode();
        result = 31 * result + dateofAction.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
