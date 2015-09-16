package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class RaceList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String raceName;

    public String getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public RaceList(){}

    public RaceList(Builder builder){
        this.id = builder.id;
        this.raceName = builder.raceName;

    }

    public static class Builder{
        private String id;
        private String raceName;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder raceName(String value){
            this.raceName = value;
            return this;
        }

        public Builder copy(RaceList value) {
            this.id = value.id;
            this.raceName = value.raceName;
            return this;
        }

        public RaceList build() {
            return new RaceList(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaceList)) return false;

        RaceList raceList = (RaceList) o;

        if (getId() != null ? !getId().equals(raceList.getId()) : raceList.getId() != null) return false;
        return !(getRaceName() != null ? !getRaceName().equals(raceList.getRaceName()) : raceList.getRaceName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRaceName() != null ? getRaceName().hashCode() : 0);
        return result;
    }
}
