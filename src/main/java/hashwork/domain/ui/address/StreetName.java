/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.ui.address;

import java.io.Serializable;

/**
 *
 * @author Garran
 */
public class StreetName implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String streetName;

    public String getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    private StreetName() {
    }

    private StreetName(Builder builder) {
        this.id = builder.id;
        this.streetName = builder.streetName;
    }

    public static class Builder {
        private String id;
        private String streetName;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder streetName(String value) {
            this.streetName = value;
            return this;
        }

        public Builder copy(StreetName value) {
            this.id = value.id;
            this.streetName = value.streetName;
            return this;
        }

        public StreetName build() {
            return new StreetName(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreetName that = (StreetName) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(streetName != null ? !streetName.equals(that.streetName) : that.streetName != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        return result;
    }
}
