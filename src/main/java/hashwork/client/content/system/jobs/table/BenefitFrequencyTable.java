package hashwork.client.content.system.jobs.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.ui.job.BenefitFrequency;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitFrequencyTable extends Table {


    private final MainLayout main;

    public BenefitFrequencyTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Frequency", String.class, null);


        // Add Data Columns
        Set<BenefitFrequency> benefitFrequencys = JobFacade.benefitFrequencyService.findAll();
        for (BenefitFrequency benefitFrequency : benefitFrequencys) {
            addItem(new Object[]{benefitFrequency.getBenefitFrequency()}, benefitFrequency.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }


}
