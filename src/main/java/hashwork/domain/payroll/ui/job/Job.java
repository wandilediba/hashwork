package hashwork.domain.payroll.ui.job;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Job implements Serializable, Comparable<Job>{
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String code ;
    private String description;
    private String salaryGradeId;
    private String jobClassificationId;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getSalaryGradeId() {
        return salaryGradeId;
    }

    public String getJobClassificationId() {
        return jobClassificationId;
    }


    private Job(){}
    private Job(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.code = builder.code;
        this.description = builder.description;
        this.salaryGradeId = builder.salaryGradeId;
        this.jobClassificationId = builder.jobClassificationId;
    }

    public static class Builder{
        private String id;
        private String title;
        private String code ;
        private String description;
        private String salaryGradeId;
        private String jobClassificationId;


        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder title(String value){
            this.title = value;
            return this;
        }
        public Builder code(String value){
            this.code = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder salaryGradeId(String value){
            this.salaryGradeId = value;
            return this;
        }
        public Builder jobClassificationId(String value){
            this.jobClassificationId = value;
            return this;
        }


        public Builder copy(Job value) {
            this.id = value.id;
            this.title = value.title;
            this.code = value.code;
            this.description = value.description;
            this.salaryGradeId = value.salaryGradeId;
            this.jobClassificationId = value.jobClassificationId;
            return this;
        }

        public Job build(){
            return new Job(this);
        }
    }

    @Override
    public int compareTo(Job o) {
        return title.compareTo(o.title);
    }
}
