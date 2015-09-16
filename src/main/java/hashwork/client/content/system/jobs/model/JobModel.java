package hashwork.client.content.system.jobs.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/09/16.
 */
public class JobModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String code;
    private String description;
    private String salaryGradeId;
    private String jobClassificationId;
    private List<String> positionIds;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(List<String> positionIds) {
        this.positionIds = positionIds;
    }

    public String getSalaryGradeId() {
        return salaryGradeId;
    }

    public void setSalaryGradeId(String salaryGradeId) {
        this.salaryGradeId = salaryGradeId;
    }

    public String getJobClassificationId() {
        return jobClassificationId;
    }

    public void setJobClassificationId(String jobClassificationId) {
        this.jobClassificationId = jobClassificationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
