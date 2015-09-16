package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by bongani on 2015/08/22.
 */
public class PersonContinuingEducation implements Serializable {
    private String id;
    private String personId;
    private String courseId;
    private String competencyEvaluationId;
    private String courseScheduleId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCompetencyEvaluationId() {
        return competencyEvaluationId;
    }

    public String getCourseScheduleId() {
        return courseScheduleId;
    }
        
    private PersonContinuingEducation() {}

         public PersonContinuingEducation(Builder builder){
            this.id =  builder.id;
            this.personId = builder.personId;
            this.courseId = builder.courseId;
            this.competencyEvaluationId = builder.competencyEvaluationId;
            this.courseScheduleId = builder.courseScheduleId;
         
        }
        public static class Builder{
            private String id;
            private String personId;
            private String courseId;
            private String competencyEvaluationId;
            private String courseScheduleId;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder courseId(String value){
            this.courseId = value;
            return this;
        }


        public Builder competencyEvaluationId(String value){
            this.competencyEvaluationId = value;
            return this;
        }
        public Builder courseScheduleId(String value){
            this.courseScheduleId = value;
            return this;
        }

       
        public Builder copy(PersonContinuingEducation value){

            this.id =  value.id;
            this.personId = value.personId;
            this.courseId = value.courseId;
            this.competencyEvaluationId = value.competencyEvaluationId;
            this.courseScheduleId = value.courseScheduleId;
           return this;
        }

        public PersonContinuingEducation build(){
            return new PersonContinuingEducation(this);

        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
