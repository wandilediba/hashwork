/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.EmployeeNumber;
import hashwork.services.ui.employee.EmployeeNumberService;
import hashwork.services.ui.employee.Impl.EmployeeNumberServiceImpl;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class EmployeeNumberTable extends Table {
    private final EmployeeNumberService employeeNumberService = new EmployeeNumberServiceImpl();
    private final MainLayout main;

    public EmployeeNumberTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("EmployeeNumber", String.class, null);


        // Add Data Columns
        Set<EmployeeNumber> employeeNumbers = employeeNumberService.findAll();
        for (EmployeeNumber employeeNumber : employeeNumbers) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
