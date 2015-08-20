/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.address.StreetName;
import hashwork.services.ui.address.Impl.StreetNameServiceImpl;
import hashwork.services.ui.address.StreetNameService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class StreetNameTable extends Table {
    private final StreetNameService streetNameService = new StreetNameServiceImpl();
    private final MainLayout main;

    public StreetNameTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("StreetName", String.class, null);


        // Add Data Columns
        Set<StreetName> streetNames = streetNameService.findAll();
        for (StreetName StreetName : streetNames) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
    