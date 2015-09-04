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
public class Number implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String number;

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    private Number(){}

    private Number(Builder builder){
        this.id = builder.id;
        this.number = builder.number;
    }

    public static class Builder{
        private String id;
        private String number;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder number(String value){
            this.number = value;
            return this;
        }

        public Builder copy(Number value) {
            this.id = value.id;
            this.number = value.number;
            return this;
        }

        public Number build() {
            return new Number(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;

        Number number1 = (Number) o;

        if (getId() != null ? !getId().equals(number1.getId()) : number1.getId() != null) return false;
        return !(getNumber() != null ? !getNumber().equals(number1.getNumber()) : number1.getNumber() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }
}
