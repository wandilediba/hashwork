package hashwork.client.content.system.office.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.Company;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/07.
 */
public class CompanyTable extends Table {
    private final MainLayout main;

    public CompanyTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Company", String.class, null);


        // Add Data Columns
        Set<Company> companies = OfficeFacade.companyService.findAll();
        for (Company company:companies) {
            addItem(new Object[]{company.getName()}, company.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
