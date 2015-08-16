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

    @Override
    public int compareTo(Competency o) {
        return name.compareTo(o.name);
    }
}
