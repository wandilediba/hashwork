package hashwork.client.content.system.jobs.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.ui.job.BenefitType;
import hashwork.domain.ui.util.Currency;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitTypeTable extends Table {

    private final MainLayout main;

    public BenefitTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Benefit Type", String.class, null);
        addContainerProperty("Amount", BigDecimal.class, null);
        addContainerProperty("CurrencyModel", String.class, null);

        // Add Data Columns
        Set<BenefitType> benefitTypes = JobFacade.benefitTypeService.findAll();
        for (BenefitType benefitType : benefitTypes) {
            addItem(new Object[]{benefitType.getBenefitTypeName(),
                    benefitType.getAmount(),
                    getCurrencyName(benefitType.getCurrencyId())
            }, benefitType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    private String getCurrencyName(String currencyId) {
        Currency currency = UtilFacade.currencyServices.findById(currencyId);
        return currency.getName();
    }
}
