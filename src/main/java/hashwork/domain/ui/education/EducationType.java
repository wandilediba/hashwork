package hashwork.domain.ui.education;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class EducationType implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    //Postgraduate, Undergraduate, College, HighHchool
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
    
     private EducationType()
    {
    
    }
    public EducationType (Builder builder){
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
        
           public Builder copy(EducationType value){
            this.id = value.id;
            this.name = value.name;
            
            return this;
        }
          public EducationType build(){
            return new EducationType(this);

        }
   }   

}
