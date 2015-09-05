/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.address.Suburb;
import hashwork.services.ui.address.Impl.SuburbServiceImpl;
import hashwork.services.ui.address.SuburbService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class SuburbTable extends Table {
    private final SuburbService subrubService = new SuburbServiceImpl();
    private final MainLayout main;

    public SuburbTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Suburb", String.class, null);


        // Add Data Columns
        Set<Suburb> suburbs = subrubService.findAll();
        for (Suburb subrub : suburbs) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
