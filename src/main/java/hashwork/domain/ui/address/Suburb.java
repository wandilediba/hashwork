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
public class Suburb implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String suburb;

    public String getId() {
        return id;
    }

    public String getSuburb() {
        return suburb;
    }

    private Suburb(){}

    private Suburb(Builder builder){
        this.id = builder.id;
        this.suburb = builder.suburb;
    }

    public static class Builder{
        private String id;
        private String suburb;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder suburb(String value){
            this.suburb = value;
            return this;
        }

        public Builder copy(Suburb value) {
            this.id = value.id;
            this.suburb = value.suburb;
            return this;
        }

        public Suburb build() {
            return new Suburb(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suburb suburb1 = (Suburb) o;

        if (id != null ? !id.equals(suburb1.id) : suburb1.id != null) return false;
        return !(suburb != null ? !suburb.equals(suburb1.suburb) : suburb1.suburb != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        return result;
    }
}
