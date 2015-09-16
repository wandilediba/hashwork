package hashwork.domain.ui.training;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Course  implements Serializable, Comparable<Course> {

    private static final long serialVersionUID = 1L;
    private String id;
    private String courseName;
    private String courseCategoryId;
    private String courseTopic;
    private String institutionNameId;
    private String courseStatusId;
    private String courseObjective;
    private int creditHours;
    private List<String> courseCompetenciesId;


    private Course(){}

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCategoryId() {
        return courseCategoryId;
    }

    public String getCourseTopic() {
        return courseTopic;
    }

    public String getInstitutionNameId() {
        return institutionNameId;
    }

    public String getCourseStatusId() {
        return courseStatusId;
    }

    public String getCourseObjective() {
        return courseObjective;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<String> getCourseCompetenciesId() {
        return courseCompetenciesId;
    }


    private Course(Builder builder) {
        this.id = builder.id;
        this.courseName = builder.courseName;
        this.courseTopic = builder.courseTopic;
        this.creditHours = builder.creditHours;
        this.courseCompetenciesId = builder.courseCompetenciesId;
        this.courseStatusId = builder.courseStatusId;
        this.courseObjective = builder.courseObjective;
        this.institutionNameId = builder.institutionNameId;
        this.courseCategoryId = builder.courseCategoryId;

    }

    public static class Builder{
        private String id;
        private String courseName;
        private String courseCategoryId;
        private String courseTopic;
        private String institutionNameId;
        private String courseStatusId;
        private String courseObjective;
        private int creditHours;
        private List<String> courseCompetenciesId;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder courseName(String value){
            this.courseName = value;
            return this;
        }

        public Builder courseCategoryId(String value){
            this.courseCategoryId = value;
            return this;
        }

        public Builder courseTopic(String value){
            this.courseTopic = value;
            return this;
        }

        public Builder institutionNameId(String value){
            this.institutionNameId = value;
            return this;
        }

        public Builder courseStatusId(String value){
            this.courseStatusId = value;
            return this;
        }

        public Builder courseObjective(String value){
            this.courseObjective = value;
            return this;
        }

        public Builder creditHours(int value){
            this.creditHours = value;
            return this;
        }

        public Builder courseCompetenciesId(List<String> value){
            this.courseCompetenciesId = value;
            return this;
        }

        public Builder copy(Course value) {
            this.id = value.id;
            this.courseCategoryId = value.courseCategoryId;
            this.courseName = value.courseName;
            this.courseTopic = value.courseTopic;
            this.courseObjective = value.courseObjective;
            this.creditHours = value.creditHours;
            this.institutionNameId = value.institutionNameId;
            this.courseStatusId = value.courseStatusId;
            this.courseCompetenciesId = value.courseCompetenciesId;

            return this;

        }

        public Course build(){
            return new Course(this);
        }


    }

    @Override
    public int compareTo(Course o) {
        return courseName.compareTo(o.courseName);
    }
}

