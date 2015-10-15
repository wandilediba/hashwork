/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.training.institutions.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.TrainingInstitutionTrainer;

import java.util.Set;

/**
 * @author BONGANI
 */
public class TrainingInstitutionTrainerTable extends Table {

    private final MainLayout main;

    public TrainingInstitutionTrainerTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("FirstName", String.class, null);
        addContainerProperty("LastName", String.class, null);
        addContainerProperty("Title", String.class, null);
        addContainerProperty("Qualification", String.class, null);

        //add columns
        Set<TrainingInstitutionTrainer> trainingInstitutionTrainers = TrainingFacade.trainingInstitutionTrainerService.findAll();
        for (TrainingInstitutionTrainer trainingInstitutionTrainer : trainingInstitutionTrainers) {
            addItem(new Object[]{trainingInstitutionTrainer.getFirstName(), trainingInstitutionTrainer.getLastName(), trainingInstitutionTrainer.getQualification(), trainingInstitutionTrainer.getTitle()}, trainingInstitutionTrainer.getId());

        }
        setNullSelectionAllowed(false);

        setSelectable(true);

        setImmediate(true);
    }

}
