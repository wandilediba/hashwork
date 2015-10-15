/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.training.registration.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.TrainingInstitution;

import java.util.Set;

/**
 * @author BONGANI
 */
public class TrainingInstitutionTable extends Table {

    private final MainLayout main;

    public TrainingInstitutionTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("TrainingInstitution", String.class, null);
        addContainerProperty("LocationContact", String.class, null);
        addContainerProperty("CityId", String.class, null);


        // Add Data Columns
        Set<TrainingInstitution> trainingInstitutions = TrainingFacade.trainingInstitutionService.findAll();
        for (TrainingInstitution trainingInstitution : trainingInstitutions) {
            addItem(new Object[]{trainingInstitution.getTrainingInstitution(),
                            trainingInstitution.getLocationContactId(),
                            trainingInstitution.getCityId()},
                    trainingInstitution.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }

}
