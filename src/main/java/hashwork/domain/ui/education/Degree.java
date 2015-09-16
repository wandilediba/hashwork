package hashwork.domain.ui.education;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String studyField;
    private String educationTypeId;
    //Bachelor , Diploma , Masters , PhD
    private String degreeName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getStudyField() {
        return studyField;
    }

    public String getEducationTypeId() {
        return educationTypeId;
    }

    public String getDegreeName() {
        return degreeName;
    }
    
    private Degree()
    {
    
    }
    public Degree (Builder builder){
        this.id = builder.id;
        this.studyField = builder.studyField;
        this.educationTypeId = builder.educationTypeId;
        this.degreeName = builder.degreeName;
      
     }
     
        public static class Builder{
        private String id;
        private String studyField;
        private String educationTypeId;
        //Bachelor , Diploma , Masters , PhD
        private String degreeName;
   
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder studyField(String value){
            this.studyField = value;
            return this;
        }
        
          public Builder educationTypeId(String value){
            this.educationTypeId = value;
            return this;
        }
          
            public Builder degreeName(String value){
            this.degreeName = value;
            return this;
        }
            
        
           public Builder copy(Degree value){
            this.id = value.id;
            this.studyField = value.studyField;
            this.educationTypeId = value.educationTypeId;
            this.degreeName = value.degreeName;
            return this;
        }
          public Degree build(){
            return new Degree(this);

        }
   }   
    
    
}
