/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.Surname;
import hashwork.services.ui.employee.Impl.SurnameServiceImpl;
import hashwork.services.ui.employee.SurnameService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class SurnameTable extends Table {
    private final SurnameService surnameService = new SurnameServiceImpl();
    private final MainLayout main;

    public SurnameTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("EmployeeNumber", String.class, null);

        // Add Data Columns
        Set<Surname> surnames = surnameService.findAll();
        for (Surname surname : surnames) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}