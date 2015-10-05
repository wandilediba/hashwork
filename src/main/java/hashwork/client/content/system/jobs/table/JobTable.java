package hashwork.client.content.system.jobs.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.ui.job.Job;
import hashwork.domain.payroll.ui.job.JobClassification;
import hashwork.domain.payroll.ui.job.SalaryGrade;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class JobTable extends Table {

    private final MainLayout main;

    public JobTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Job Title", String.class, null);
        addContainerProperty("Job Code", String.class, null);
        addContainerProperty("Job Description", String.class, null);
        addContainerProperty("Salary Grade", String.class, null);
        addContainerProperty("Job Classification", String.class, null);

        // Add Data Columns
        Set<Job> jobs = JobFacade.jobService.findAll();
        for (Job job : jobs) {
            addItem(new Object[]{job.getTitle(),
                    job.getCode(),
                    job.getDescription(),
                    getGradeName(job.getSalaryGradeId()),
                    getClassification(job.getJobClassificationId())
            }, job.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getGradeName(String salaryGradeId) {
        SalaryGrade salaryGrade = JobFacade.salaryGradeService.findById(salaryGradeId);
        return salaryGrade.getGradeName();
    }

    private String getClassification(String jobClassificationId) {
        JobClassification jobClassification = JobFacade.jobClassificationService.findById(jobClassificationId);
        return jobClassification.getCurrentTitle();
    }
}
