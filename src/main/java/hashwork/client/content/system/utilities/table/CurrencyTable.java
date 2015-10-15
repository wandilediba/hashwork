package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Currency;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/12.
 */
public class CurrencyTable extends Table {


    private final MainLayout main;

    public CurrencyTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Currency Name", String.class, null);
        addContainerProperty("Currency Code", String.class, null);
        addContainerProperty("Currency Symbol", String.class, null);

        // Add Data Columns
        Set<Currency> currencys = UtilFacade.currencyServices.findAll();
        for (Currency currency : currencys) {
            addItem(new Object[]{currency.getName(), currency.getCode(), currency.getSymbol()}, currency.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
