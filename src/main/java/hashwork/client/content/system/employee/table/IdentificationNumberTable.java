/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.IdentificationNumber;
import hashwork.services.ui.employee.IdentificationNumberService;
import hashwork.services.ui.employee.Impl.IdentificationNumberServiceImpl;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class IdentificationNumberTable extends Table {
    private final IdentificationNumberService identificationNumberService = new IdentificationNumberServiceImpl();
    private final MainLayout main;

    public IdentificationNumberTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("IdentificationNumber", String.class, null);


        // Add Data Columns
        Set<IdentificationNumber> identificationNumbers = identificationNumberService.findAll();
        for (IdentificationNumber employeeNumber : identificationNumbers) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}