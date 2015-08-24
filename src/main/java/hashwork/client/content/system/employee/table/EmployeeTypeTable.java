/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.EmployeeType;
import hashwork.services.ui.employee.EmployeeTypeService;
import hashwork.services.ui.employee.Impl.EmployeeTypeServiceImpl;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class EmployeeTypeTable extends Table {
    private final EmployeeTypeService employeeTypeService = new EmployeeTypeServiceImpl();
    private final MainLayout main;

    public EmployeeTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("EmployeeType", String.class, null);


        // Add Data Columns
        Set<EmployeeType> employeeTypes = employeeTypeService.findAll();
        for (EmployeeType employeeType : employeeTypes) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}