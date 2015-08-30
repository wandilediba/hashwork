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
public class PostalCode implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String postalCode;

    public String getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    private PostalCode(){}

    private PostalCode(Builder builder){
        this.id = builder.id;
        this.postalCode = builder.postalCode;
    }

    public static class Builder{
        private String id;
        private String postalCode;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder postalCode(String value){
            this.postalCode = value;
            return this;
        }

        public Builder copy(PostalCode value) {
            this.id = value.id;
            this.postalCode = value.postalCode;
            return this;
        }

        public PostalCode build() {
            return new PostalCode(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostalCode that = (PostalCode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
