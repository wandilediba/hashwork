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
}
