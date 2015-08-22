package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonHiringDecision implements Serializable {
    private String id;
    private String personId;
    private Date decisionDate;
    private String decision;
    private String comments;
    private String decisionMakerId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public String getDecision() {
        return decision;
    }

    public String getComments() {
        return comments;
    }

    public String getDecisionMakerId() {
        return decisionMakerId;
    }
    
    public PersonHiringDecision() { }
    
    public PersonHiringDecision (Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.decisionDate = builder.decisionDate;
        this.decision = builder.decision;
        this.comments = builder.comments;
        this.decisionMakerId = builder.decisionMakerId;                
    }
    public static class Builder{
        private String id;
        private String personId;
        private Date decisionDate;
        private String decision;
        private String comments;
        private String decisionMakerId;      
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
         public PersonHiringDecision.Builder decisionDate(Date date){
            this.decisionDate = date;
            return this;
        }
         
         public PersonHiringDecision.Builder decision(String value){
            this.decision = value;
            return this;
        }
         public PersonHiringDecision.Builder comments(String value){
            this.comments = value;
            return this;
        }
         public PersonHiringDecision.Builder decisionMakerId(String value){
            this.decisionMakerId = value;
            return this;
        }
        public Builder copy(PersonHiringDecision value){
            this.id =  value.id;
            this.personId = value.personId;
            this.decisionDate = value.decisionDate;
            this.decision = value.decision;
            this.comments = value.comments;
            this.decisionMakerId = value.decisionMakerId;
            return this;
        }         
        
    }     
      public static Builder builder() {
        return new Builder();
    }    
    
}
