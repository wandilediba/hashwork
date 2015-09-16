package hashwork.domain.ui.education;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Competency implements Serializable,Comparable<Competency>{
    private static final long serialVersionUID = 1L;

    private String id;
    //competency type Computer Skills, specific competencies could include Data Entry, Software Use and Document Formatting
    private String name;
    private String competencyTypeId;
    private String notes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompetencyTypeId() {
        return competencyTypeId;
    }

    public String getNotes() {
        return notes;
    }
     private Competency()
    {
    
    }
    public Competency (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.competencyTypeId = builder.competencyTypeId;  
        this.notes = builder.notes; 
     }
     
        public static class Builder{
        private String id;
        private String name;
        private String competencyTypeId;
          private String notes;
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            this.name = value;
            return this;
        }
        
        public Builder competencyTypeId(String value){
            this.competencyTypeId = value;
            return this;
        }
              
           public Builder Notes(String value){
            this.notes = value;
            return this;
        }
           
         public Builder copy(Competency value){
            this.id = value.id;
            this.name = value.name;
            this.competencyTypeId = value.competencyTypeId;
            this.notes = value.notes;
            return this;
        }
          public Competency build(){
            return new Competency(this);

        }
   }   

    @Override
    public int compareTo(Competency o) {
        return name.compareTo(o.name);
    }
}
