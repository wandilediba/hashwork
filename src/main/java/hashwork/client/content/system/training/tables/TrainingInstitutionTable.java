package hashwork.client.content.system.training.tables;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.TrainingInstitution;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/08.
 */
public class TrainingInstitutionTable extends Table {

    private final MainLayout main;

    public TrainingInstitutionTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Institution Name", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Postal  Address", String.class, null);
        addContainerProperty("Physical Address", String.class, null);
        addContainerProperty("Postal Code", String.class, null);
        addContainerProperty("City", String.class, null);


        // Add Data Columns
        Set<TrainingInstitution> trainingInstitutions = TrainingFacade.trainingInstitutionService.findAll();
        for (TrainingInstitution trainingInstitution : trainingInstitutions) {
            addItem(new Object[]{trainingInstitution.getTrainingInstitution(),
                    trainingInstitution.getContact().getContactNumber(),
                    trainingInstitution.getContact().getPostalAddress(),
                    trainingInstitution.getContact().getPhysicalAddress(),
                    trainingInstitution.getContact().getPostalCode(),
                    trainingInstitution.getCity().getName()}, trainingInstitution.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}