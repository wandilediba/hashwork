package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zamzam on 15/09/22.
 */
public class JobModel implements Serializable {

    private String title;
    private String code ;
    private String description;
    private String salaryGradeId;
    private String jobClassificationId;
    private List<String> positionIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(List<String> positionIds) {
        this.positionIds = positionIds;
    }
}
