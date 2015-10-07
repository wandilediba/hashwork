package hashwork.client.content.system.office.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.Office;

import java.util.Date;
import java.util.Set;

/**
 * Created by zamzam on 2015/10/07.
 */
public class OfficeTable extends Table {
    private final MainLayout main;

    public OfficeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Active", String.class, null);
        addContainerProperty("City", String.class, null);
        addContainerProperty("Contact", String.class, null);
        addContainerProperty("Office Type", String.class, null);
        addContainerProperty("Date Established", Date.class, null);

        // Add Data Columns
        Set<Office> offices = OfficeFacade.officeService.findAll();
        for (Office office : offices) {
            addItem(new Object[]{office.getName(),
                    office.getDescription(),
                    office.getActive(),
                    getCity(office.getId()),
                    getContact(office.getContactId()),
                    getOfficeType(office.getOfficeTypeId()),
                    office.getDateEstablished()}, office.getId());
        }


        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getCity(String cityId) {
        if (cityId != null) {
            return OfficeFacade.officeService.findById(cityId).getName();
        }
        return null;
    }

    private String getContact(String contactId) {
        if (contactId != null) {
            return OfficeFacade.officeService.findById(contactId).getName();
        }
        return null;
    }

    private String getOfficeType(String officeTypeId) {
        if (officeTypeId != null) {
            return OfficeFacade.officeService.findById(officeTypeId).getName();
        }
        return null;
    }
}
