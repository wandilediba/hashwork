/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.payroll.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PayrollCoreDeductionsFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.core.deductions.EmployeeLeaveData;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class EmployeeLeaveDataTable extends Table{
    
    private final MainLayout main;

    public EmployeeLeaveDataTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("CommencementDate", String.class, null);
        addContainerProperty("DaysTaken", String.class, null);
        addContainerProperty("LeaveType", String.class, null);
        addContainerProperty("PersonId", String.class, null);
        addContainerProperty("PaidLeave", String.class, null);
        

        // Add Data Columns
        Set<EmployeeLeaveData> employeeLeaveData = PayrollCoreDeductionsFacade.employeeLeaveDataService.findAll();
        for (EmployeeLeaveData employeeLeave : employeeLeaveData) {
            addItem(new Object[]{
            employeeLeave.getCommencementDate(),
            employeeLeave.getDaysTaken(),
            employeeLeave.getLeaveType(),
            employeeLeave.getPersonId(),
            employeeLeave.isPaidLeave()}, employeeLeave.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
