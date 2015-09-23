package hashwork.client.content.system.jobs.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.ui.job.JobClassification;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class JobClassificationTable extends Table {

    private final MainLayout main;

    public JobClassificationTable(MainLayout main) {
        this.main = main;
        setSizeFull();

//                    private String currentTitle;
//    private String oldTitle;
//    private String oldCode;
//    private String description;
//    private String currentCode;
//    private String codeConversion;
//    private String comment;

        addContainerProperty("Current Title", String.class, null);
        addContainerProperty("Old Title", String.class, null);
        addContainerProperty("Old Code", String.class, null);
        addContainerProperty("Current Code", String.class, null);
        addContainerProperty("Code Conversion", String.class, null);
        addContainerProperty("Comment", String.class, null);


        // Add Data Columns
        Set<JobClassification> jobClassifications = JobFacade.jobClassificationService.findAll();
        for (JobClassification jobClassification : jobClassifications) {
            addItem(new Object[]{jobClassification.getCurrentTitle(),
                    jobClassification.getOldTitle(),
                    jobClassification.getOldCode(),
                    jobClassification.getCurrentCode(),
                    jobClassification.getCodeConversion(),
                    jobClassification.getComment()
            }, jobClassification.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
