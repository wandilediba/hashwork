package hashwork.domain.ui.contactdetails;

import java.io.Serializable;

/**
 * Created by garran on 2015/08/31.
 */
public class EmailAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String emailAddress;

    public String getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private EmailAddress() {
    }

    private EmailAddress(Builder builder) {
        this.id = builder.id;
        this.emailAddress = builder.emailAddress;
    }

    public static class Builder {
        private String id;
        private String emailAddress;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder emailAddress(String value) {
            this.emailAddress = value;
            return this;
        }

        public Builder copy(EmailAddress value) {
            this.id = value.id;
            this.emailAddress = value.emailAddress;
            return this;
        }

        public EmailAddress build() {
            return new EmailAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;

        EmailAddress that = (EmailAddress) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getEmailAddress() != null ? !getEmailAddress().equals(that.getEmailAddress()) : that.getEmailAddress() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        return result;
    }
}