package hashwork.domain.ui.education;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyType implements Serializable {

    private static final long serialVersionUID = 1L;
      private String id;
    // Computer Skills, Client Interaction and Accounting based on Company Competeancy Model
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    private CompetencyType()
    {
    
    }
    public CompetencyType (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
      
     }
     
        public static class Builder{
        private String id;
        private String name;
   
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            this.name = value;
            return this;
        }
        
           public Builder copy(CompetencyType value){
            this.id = value.id;
            this.name = value.name;
            
            return this;
        }
          public CompetencyType build(){
            return new CompetencyType(this);

        }
   }   

}
