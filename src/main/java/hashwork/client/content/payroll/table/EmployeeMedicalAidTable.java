/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.payroll.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PayrollCoreDeductionsFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.payroll.core.deductions.EmployeeMedicalAid;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class EmployeeMedicalAidTable extends Table{
    
    private final MainLayout main;

    public EmployeeMedicalAidTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("LastDateContribution", String.class, null);
        addContainerProperty("MedicalAidAmount", String.class, null);
        addContainerProperty("MedicalAidType", String.class, null);
        addContainerProperty("PersonId", String.class, null);


        // Add Data Columns
        Set<EmployeeMedicalAid> addressTypes = PayrollCoreDeductionsFacade.employeeMedicalAidService.findAll();
        for (EmployeeMedicalAid addressType : addressTypes) {
            addItem(new Object[]{addressType.getLastDateContribution(),
            addressType.getMedicalAidAmount(),
            addressType.getMedicalAidType(),
            addressType.getPersonId()}, addressType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
    
}
