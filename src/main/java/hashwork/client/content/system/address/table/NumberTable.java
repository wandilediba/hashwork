/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.services.ui.address.Impl.NumberServiceImpl;
import hashwork.services.ui.address.NumberService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class NumberTable extends Table {
    private final NumberService numberervice = new NumberServiceImpl();
    private final MainLayout main;

    public NumberTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Number", String.class, null);


        // Add Data Columns
        Set<Number> numbers = numberervice.findAll();
        for (Number number : numbers) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
