/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Status;
import java.util.Set;

/**
 *
 * @author bulelani
 */
public class StatusTable extends Table {
    private final MainLayout main;
    
    public StatusTable(MainLayout main){
        this.main = main;
        setSizeFull();
        
        addContainerProperty("Status Type", String.class, null);
        addContainerProperty("Status Values", String.class, null);
        
        Set<Status> status = UtilFacade.statusService.findAll();
        for(Status stat : status){
            addItem(new Object[]{stat.getStatusType(),
                            stat.getStatusValues()},
                            stat.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
