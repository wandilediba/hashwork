/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.address.PostalCode;
import hashwork.services.ui.address.Impl.PostalCodeServiceImpl;
import hashwork.services.ui.address.PostalCodeService;
import java.util.Set;

/**
 *
 * @author Garran
 */
public class PostalCodeTable extends Table {
    private final PostalCodeService postalCodeService = new PostalCodeServiceImpl();
    private final MainLayout main;

    public PostalCodeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("PostalCode", String.class, null);


        // Add Data Columns
        Set<PostalCode> postalCodes = postalCodeService.findAll();
        for (PostalCode postalCode : postalCodes) {
            // addItem(new Object[]{language.getName()}, language.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
