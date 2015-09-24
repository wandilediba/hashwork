package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String ScheduledCourseId;
    private String trainerId;

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return ScheduledCourseId;
    }

    public String getTrainerId() {
        return trainerId;
    }


    private ScheduledCourseInstructor(){}

    private ScheduledCourseInstructor(Builder builder) {
        this.id = builder.id;
        this.ScheduledCourseId = builder.ScheduledCourseId;
        this.trainerId = builder.trainerId;

    }

    public static class Builder {

        private String id;
        private String ScheduledCourseId;
        private String trainerId;


        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder scheduledCourseId(String value) {
            this.ScheduledCourseId = value;
            return this;
        }

        public Builder trainerId(String value) {
            this.trainerId = value;
            return this;
        }

        public Builder copy(ScheduledCourseInstructor value) {
            this.id = value.id;
            this.ScheduledCourseId = value.ScheduledCourseId;
            this.trainerId = value.trainerId;

            return this;
        }

        public ScheduledCourseInstructor build(){
            return new ScheduledCourseInstructor(this);
        }

    }
}
