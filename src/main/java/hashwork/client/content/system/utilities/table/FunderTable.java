/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Funder;
import java.util.Set;

/**
 * 
 * @author bulelani
 */
public class FunderTable extends Table{
  private final MainLayout main;
  
  public FunderTable(MainLayout main){
      this.main = main;
      setSizeFull();
      
        addContainerProperty("Training Funder Name", String.class, null);
        addContainerProperty("Cost Center", String.class, null);
        addContainerProperty("City Id", String.class, null);
        addContainerProperty("Location Contact Id", String.class, null);
        
        //Add Data Columns
        Set<Funder> funders = UtilFacade.funderService.findAll();
        for(Funder funder : funders){
            addItem(new Object[]{funder.getTrainingFunderName(),
                            funder.getCostCenter(),
                            funder.getCityId(),
                            funder.getLocationContactId()},funder.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
  }
}
