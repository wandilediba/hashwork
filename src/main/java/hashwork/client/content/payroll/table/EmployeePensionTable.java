/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.payroll.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PayrollCoreDeductionsFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.core.deductions.EmployeePension;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class EmployeePensionTable extends Table{
    
    private final MainLayout main;

    public EmployeePensionTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("ContributionToDate", String.class, null);
        addContainerProperty("GoalAmount", String.class, null);
        addContainerProperty("LastContribution", String.class, null);
        addContainerProperty("LastContributionDate", String.class, null);
        addContainerProperty("PensionCode", String.class, null);
        addContainerProperty("PersonId", String.class, null);
        addContainerProperty("StartDate", String.class, null);
        


        // Add Data Columns
        Set<EmployeePension> addressTypes = PayrollCoreDeductionsFacade.employeePensionService.findAll();
        for (EmployeePension addressType : addressTypes) {
            addItem(new Object[]{addressType.getContributionToDate(),
            addressType.getGoalAmount(),
            addressType.getLastContribution(),
            addressType.getLastContributionDate(),
            addressType.getPensionCode(),
            addressType.getPersonId(),
            addressType.getStartDate()}, addressType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
