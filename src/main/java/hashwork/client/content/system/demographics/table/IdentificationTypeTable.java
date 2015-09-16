package hashwork.client.content.system.demographics.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.demographics.IdentificationType;
import hashwork.services.ui.demographics.IdentificationTypeService;
import hashwork.services.ui.demographics.Impl.IdentificationTypeServiceImpl;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class IdentificationTypeTable extends Table {
    private final MainLayout main;
    private final IdentificationTypeService identificationTypeService = new IdentificationTypeServiceImpl();

    public IdentificationTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

//    private String idvalue;
//    private String description;


        addContainerProperty("Identication Description ", String.class, null);
        addContainerProperty("IIdentification Number", String.class, null);

        // Add Data Columns
        Set<IdentificationType> identificationTypes = identificationTypeService.findAll();
        for (IdentificationType identificationType : identificationTypes) {
            //addItem(new Object[]{identificationType.getDescription(),identificationType.getIdvalue()}, identificationType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }

}
