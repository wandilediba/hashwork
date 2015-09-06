/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.HireDate;
import hashwork.services.ui.employee.HireDateService;
import hashwork.services.ui.employee.Impl.HireDateServiceImpl;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class HireDateTable extends Table {
    private final HireDateService hireDatesService = new HireDateServiceImpl();
    private final MainLayout main;

    public HireDateTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("HireDate", String.class, null);


        // Add Data Columns
        Set<HireDate> hireDates = hireDatesService.findAll();
        for (HireDate hireDate : hireDates) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}