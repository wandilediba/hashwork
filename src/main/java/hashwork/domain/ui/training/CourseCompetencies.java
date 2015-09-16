package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseCompetencies implements Serializable {
    private String id;
    private String courseId;
    private String  competencyId;

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCompetencyId() {
        return competencyId;
    }

    private CourseCompetencies(){}

    private CourseCompetencies(Builder builder) {
        this.id = builder.id;
        this.courseId = builder.courseId;
        this.competencyId = builder.competencyId;
    }

    public static class Builder{
        private String id;
        private String courseId;
        private String  competencyId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder courseId(String value){
            this.courseId = value;
            return this;
        }

        public Builder competencyid(String value){
            this.competencyId = value;
            return this;
        }

        public Builder copy(CourseCompetencies value) {
            this.id = value.id;
            this.courseId = value.courseId;
            this.competencyId = value.competencyId;

            return this;
        }

        public CourseCompetencies build(){
            return new CourseCompetencies(this);
        }

    }
}
