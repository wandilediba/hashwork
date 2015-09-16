package hashwork.domain.ui.position;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionLifeCycle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String positionId;
    private Date dateofAction;
    private String status;

    public PositionLifeCycle(){}

    public String getId() {
        return id;
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

    private PositionLifeCycle(Builder builder) {
        this.id = builder.id;
        this.positionId = builder.positionId;
        this.dateofAction = builder.dateofAction;
        this.status = builder.status;
    }

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
            this.id = value.id;
            this.dateofAction = value.dateofAction;
            this.status = value.status;
            this.positionId = value.positionId;
            return this;
        }

        public PositionLifeCycle build(){
            return new PositionLifeCycle(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionLifeCycle that = (PositionLifeCycle) o;

        if (!id.equals(that.id)) return false;
        if (!positionId.equals(that.positionId)) return false;
        if (!dateofAction.equals(that.dateofAction)) return false;
        return status.equals(that.status);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + positionId.hashCode();
        result = 31 * result + dateofAction.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
