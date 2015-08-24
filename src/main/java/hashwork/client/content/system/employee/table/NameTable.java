/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.employee.Name;
import hashwork.services.ui.employee.Impl.NameServiceImpl;
import hashwork.services.ui.employee.NameService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class NameTable extends Table {
    private final NameService nameService = new NameServiceImpl();
    private final MainLayout main;

    public NameTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);


        // Add Data Columns
        Set<Name> names = nameService.findAll();
        for (Name name : names) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}