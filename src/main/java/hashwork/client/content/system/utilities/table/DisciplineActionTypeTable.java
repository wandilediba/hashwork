/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.DisciplineActionTypeList;
import java.util.Set;

/**
 *
 * @author bulelani
 */
public class DisciplineActionTypeTable  extends Table{
    private final MainLayout main;
    
    public DisciplineActionTypeTable(MainLayout main){
       this.main = main;
       setSizeFull();
       
       addContainerProperty("Name", String.class, null);
       addContainerProperty("Description", String.class, null);
       
        //Add Data Columns
       Set<DisciplineActionTypeList> disciplineTypes = UtilFacade.disciplineActionTypeListService.findAll();
       for(DisciplineActionTypeList disciplineType : disciplineTypes){
           addItem(new Object[]{disciplineType.getName(),
                            disciplineType.getDescription()},disciplineType.getId());
       }
       //Allow selecting items from the table
       setNullSelectionAllowed(false);
       
       setSelectable(true);
       // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
