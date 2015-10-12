/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.payroll.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PayrollCoreDeductionsFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.core.deductions.EmployeeDeductions;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class EmployeeDeductionsTable extends Table{
    
    
     private final MainLayout main;

     public EmployeeDeductionsTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("DeductionAmt", String.class, null);
        addContainerProperty("DeductionTypeDesc", String.class, null);
        addContainerProperty("PersonId", String.class, null);


        // Add Data Columns
        Set<EmployeeDeductions> employeeDeductions = PayrollCoreDeductionsFacade.employeeDeductionsServices.findAll();
        for (EmployeeDeductions employeeDeduction : employeeDeductions) {
            addItem(new Object[]{employeeDeduction.getDeductionAmt(),
                employeeDeduction.getDeductionTypeDesc(),
                employeeDeduction.getPersonId()
            }, employeeDeduction.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }

    
}
