package hashwork.domain.ui.contactdetails;

import java.io.Serializable;

/**
 * Created by garran on 2015/08/31.
 */
public class HomeNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String homeNumber;

    public String getId() {
        return id;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    private HomeNumber() {
    }

    private HomeNumber(Builder builder) {
        this.id = builder.id;
        this.homeNumber = builder.homeNumber;
    }

    public static class Builder {
        private String id;
        private String homeNumber;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder homeNumber(String value) {
            this.homeNumber = value;
            return this;
        }

        public Builder copy(HomeNumber value) {
            this.id = value.id;
            this.homeNumber = value.homeNumber;
            return this;
        }

        public HomeNumber build() {
            return new HomeNumber(this);
        }
    }

}