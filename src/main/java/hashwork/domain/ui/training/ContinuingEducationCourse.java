package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ContinuingEducationCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseName;
    private int creditHours;


    private ContinuingEducationCourse(){}

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    private ContinuingEducationCourse(Builder builder) {
        this.id = builder.id;
        this.courseName = builder.courseName;
        this.creditHours = builder.creditHours;

    }

    public static class Builder{
        private String id;
        private String courseName;
        private int creditHours;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder courseName(String value){
            this.courseName = value;
            return this;
        }

        public Builder creditHours(int value){
            this.creditHours = value;
            return this;
        }

        public Builder copy(ContinuingEducationCourse value) {
            this.id = value.id;
            this.courseName = value.courseName;
            this.creditHours = value.creditHours;

            return this;
        }

        public ContinuingEducationCourse build(){
            return new ContinuingEducationCourse(this);
        }


    }
}
