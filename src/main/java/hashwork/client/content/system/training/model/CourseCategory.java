package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CourseCategory  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String categoryName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
