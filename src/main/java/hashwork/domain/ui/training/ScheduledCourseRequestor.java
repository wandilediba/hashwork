package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseRequestor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String scheduledCourseId;
    private String requesterId;

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return scheduledCourseId;
    }

    public String getRequesterId() {
        return requesterId;
    }


    private ScheduledCourseRequestor(){}

    private ScheduledCourseRequestor(Builder builder) {
        this.id = builder.id;
        this.scheduledCourseId = builder.scheduledCourseId;
        this.requesterId = builder.requesterId;

    }

    public static class Builder {

        private String id;
        private String scheduledCourseId;
        private String requesterId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder scheduledCourseId(String value) {
            this.scheduledCourseId = value;
            return this;
        }

        public Builder requesterId(String value) {
            this.requesterId = value;
            return this;
        }

        public Builder copy(ScheduledCourseRequestor value) {
            this.id = value.id;
            this.scheduledCourseId = value.scheduledCourseId;
            this.requesterId = value.requesterId;

            return this;
        }

        public ScheduledCourseRequestor build() {
            return new ScheduledCourseRequestor(this);
        }

    }
}
