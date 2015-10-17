/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.payroll.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PayrollCoreDeductionsFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.core.deductions.EmployeeUIFContribution;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class EmployeeUIFContributionTable extends Table{
    
    private final MainLayout main;

    public EmployeeUIFContributionTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Contribution", String.class, null);
        addContainerProperty("Country", String.class, null);
        addContainerProperty("CurrentAmount", String.class, null);
        addContainerProperty("LastContributionDate", String.class, null);
        addContainerProperty("PersonId", String.class, null);


        // Add Data Columns
        Set<EmployeeUIFContribution> addressTypes = PayrollCoreDeductionsFacade.employeeUIFContributionService.findAll();
        for (EmployeeUIFContribution addressType : addressTypes) {
            addItem(new Object[]{addressType.getContribution(),
            addressType.getCountry(),
            addressType.getCurrentAmount(),
            addressType.getLastContributionDate(),
            addressType.getPersonId()}, addressType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
