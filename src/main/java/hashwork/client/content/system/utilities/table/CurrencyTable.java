/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Currency;
import java.util.Set;

/**
 *
 * @author bulelani
 */
public class CurrencyTable extends Table{
    private final MainLayout main;
    
    public CurrencyTable(MainLayout main){
       this.main = main; 
       setSizeFull();
       
       addContainerProperty("Code", String.class, null);
       addContainerProperty("Name", String.class, null);
       addContainerProperty("Symbol", String.class, null);
       
       //Add Data Columns
       Set<Currency> currencies = UtilFacade.currencyServices.findAll();
       for(Currency currency : currencies){
           addItem(new Object[]{currency.getCode(),
                            currency.getName(),
                            currency.getSymbol()}, currency.getId());
       }
       //Allow selecting items from the table
       setNullSelectionAllowed(false);
       
       setSelectable(true);
       // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
