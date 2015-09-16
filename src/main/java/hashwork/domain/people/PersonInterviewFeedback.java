package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonInterviewFeedback implements Serializable {
    private String id;
    private String personId;
    private String penalistId;
    private Date intervieDate;
    private String comments;
    private int rating;

    public String getId() {
        return id;
    }
    public String getPersonId() {
        return personId;
    }
    public String getPenalistId() {
        return penalistId;
    }
    public Date getIntervieDate() {
        return intervieDate;
    }
    public String getComments() {
        return comments;
    }
    public int getRating() {
        return rating;
    }
   
    private PersonInterviewFeedback() { }

         public PersonInterviewFeedback(Builder builder){
            this.id =  builder.id;
            this.personId = builder.personId;
            this.penalistId = builder.penalistId;
            this.intervieDate = builder.intervieDate;
            this.comments = builder.comments;
            this.rating = builder.rating;
         }
         
        public static class Builder{
            private String id;
            private String personId;
            private String penalistId;
            private Date intervieDate;
            private String comments;
            private int rating;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder penalistId(String value){
            this.penalistId = value;
            return this;
        }

        public Builder intervieDate(Date value){
            this.intervieDate = value;
            return this;
        }
        public Builder comments(String value){
            this.comments = value;
            return this;
        }
        public Builder rating(int value){
            this.rating = value;
            return this;
        }
        public Builder copy(PersonInterviewFeedback value){

            this.id =  value.id;
            this.personId = value.personId;
            this.penalistId = value.penalistId;
            this.intervieDate = value.intervieDate;
            this.comments = value.comments;
            this.rating = value.rating;
            return this;
        }
        public PersonInterviewFeedback build(){
            return new PersonInterviewFeedback(this);

        }
    }

    public static Builder builder() {
        return new Builder();
    }
    

}
