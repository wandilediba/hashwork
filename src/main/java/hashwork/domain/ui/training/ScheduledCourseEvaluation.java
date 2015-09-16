package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseEvaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String scheduledCourseId;
    private int  rating ;
    private String comments;

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return scheduledCourseId;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }


    private ScheduledCourseEvaluation(){}

    private ScheduledCourseEvaluation(Builder builder) {
        this.id = builder.id;
        this.scheduledCourseId = builder.scheduledCourseId;
        this.comments = builder.comments;
        this.rating = builder.rating;

    }

    public static class Builder{

        private String id;
        private String scheduledCourseId;
        private int  rating ;
        private String comments;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder scheduledCourseId(String value){
            this.scheduledCourseId = value;
            return this;
        }

        public Builder rating(int value){
            this.rating = value;
            return this;
        }

        public Builder comments(String value){
            this.comments = value;
            return this;
        }

        public Builder copy(ScheduledCourseEvaluation value) {
            this.id = value.id;
            this.scheduledCourseId = value.scheduledCourseId;
            this.rating = value.rating;
            this.comments = value.comments;

            return this;

        }

        public ScheduledCourseEvaluation build(){
            return new ScheduledCourseEvaluation(this);
        }




    }
}
