package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class IdentificationType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String idvalue;
    private String description;

    public String getId() {
        return id;
    }

    public String getIdvalue() {
        return idvalue;
    }

    public String getDescription() {
        return description;
    }

    private IdentificationType(){}

    private IdentificationType(Builder builder){
        
    }

    public static class Builder{
        private String id;
        private String idvalue;
        private String description;

    }
}
