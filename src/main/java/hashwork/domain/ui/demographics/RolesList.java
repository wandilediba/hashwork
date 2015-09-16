package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class RolesList  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String roleName;
    private String description;

    public String getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    private RolesList(){

    }
    private RolesList(Builder builder){
        this.id = builder.id;
        this.roleName = builder.roleName;
        this.description = builder.description;
    }

    public static class Builder{
        private String id;
        private String roleName;
        private String description;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder roleName(String value){
            this.roleName = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }

        public Builder copy(RolesList value) {
            this.id = value.id;
            this.roleName = value.roleName;
            this.description = value.description;
            return this;
        }

        public RolesList build() {
            return new RolesList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolesList)) return false;

        RolesList rolesList = (RolesList) o;

        if (getId() != null ? !getId().equals(rolesList.getId()) : rolesList.getId() != null) return false;
        if (getRoleName() != null ? !getRoleName().equals(rolesList.getRoleName()) : rolesList.getRoleName() != null)
            return false;
        return !(getDescription() != null ? !getDescription().equals(rolesList.getDescription()) : rolesList.getDescription() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
