package hashwork.domain.ui.location;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ContactList implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private ContactList(){

    }
    private ContactList(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder{
        private String id;
        private String name;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder name(String value){
            this.name = value;
            return  this;
        }

        public Builder copy(ContactList value) {
            this.id = value.id;
            this.name = value.name;
            return this;
        }

        public ContactList build(){
            return new ContactList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactList)) return false;

        ContactList that = (ContactList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getName() != null ? !getName().equals(that.getName()) : that.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
