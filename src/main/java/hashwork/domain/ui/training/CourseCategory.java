package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseCategory  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String categoryName;

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private CourseCategory(){}

    private CourseCategory(Builder builder) {
        this.id = builder.id;
        this.categoryName = builder.categoryName;
    }


    public static class Builder{

        private String id;
        private String categoryName;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder categoryName(String value){
            this.categoryName = value;
            return this;
        }

        public Builder copy(CourseCategory value) {
            this.id = value.id;
            this.categoryName = value.categoryName;

            return this;
        }

        public CourseCategory build(){
            return new CourseCategory(this);
        }

    }

}
