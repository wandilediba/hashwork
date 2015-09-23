package hashwork.client.content.system.jobs.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.ui.job.SalaryGrade;
import hashwork.domain.ui.util.Currency;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class SalaryGradeTable extends Table {

    private final MainLayout main;

    public SalaryGradeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Grade Name", String.class, null);
        addContainerProperty("Current Amount", BigDecimal.class, null);
        addContainerProperty("Start Amount", BigDecimal.class, null);
        addContainerProperty("Mid Amount", BigDecimal.class, null);
        addContainerProperty("End Amount", BigDecimal.class, null);
        addContainerProperty("CurrencyModel", String.class, null);
        addContainerProperty("Notes", String.class, null);

        // Add Data Columns
        Set<SalaryGrade> salaryGrades = JobFacade.salaryGradeService.findAll();
        for (SalaryGrade salaryGrade : salaryGrades) {
            addItem(new Object[]{salaryGrade.getGradeName(),
                    salaryGrade.getCurrentAmount(),
                    salaryGrade.getStartAmount(),
                    salaryGrade.getMidAmount(),
                    salaryGrade.getEndAmount(),
                    getCurrencySymbol(salaryGrade.getCurrencyId()),
                    salaryGrade.getNotes()}, salaryGrade.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    private String getCurrencySymbol(String currencyId) {
        Currency currency = UtilFacade.currencyServices.findById(currencyId);
        return currency.getSymbol();

    }
}
