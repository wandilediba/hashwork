package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class TitleList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    private TitleList(){

    }
    private TitleList(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
    }

    public static class Builder{
        private String id;
        private String title;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder title(String value){
            this.title = value;
            return this;
        }

        public Builder copy(TitleList value) {
            this.id = value.id;
            this.title = value.title;
            return this;
        }

        public TitleList build() {
            return new TitleList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleList)) return false;

        TitleList titleList = (TitleList) o;

        if (getId() != null ? !getId().equals(titleList.getId()) : titleList.getId() != null) return false;
        return !(getTitle() != null ? !getTitle().equals(titleList.getTitle()) : titleList.getTitle() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }
}
