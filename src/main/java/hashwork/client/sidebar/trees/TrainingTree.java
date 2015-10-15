package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.employee.EmployeeTrainingMenu;
import hashwork.client.content.training.institutions.InstitutionManagementMenu;
import hashwork.client.content.training.registration.InstitutionRegistrationMenu;

/**
 * Created by hashcode on 2015/08/17.
 */
public class TrainingTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    public static final Object TRAINING_INSTITUTION = "Training INSTITUTION";
    public static final Object EMPLOYEE_TRAINING = "Employee TRAINING";
    public static final Object REGISTER_INSTITUTION = "Register INSTITUTION";
    private static final String LANDING_TAB = "LANDING";

    public TrainingTree(MainLayout main) {
        this.main = main;
        addItem(REGISTER_INSTITUTION);
        addItem(TRAINING_INSTITUTION);
        addItem(EMPLOYEE_TRAINING);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);

    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (TRAINING_INSTITUTION.equals(itemId)) {
                trainingInstitutionView();
            } else if (EMPLOYEE_TRAINING.equals(itemId)) {
                employeeTrainingView();
            } else if (REGISTER_INSTITUTION.equals(itemId)) {
                registerInstituionView();
            }
        }
    }

    private void trainingInstitutionView() {
        main.content.setSecondComponent(new InstitutionManagementMenu(main, LANDING_TAB));

    }

    private void employeeTrainingView() {
        main.content.setSecondComponent(new EmployeeTrainingMenu(main, LANDING_TAB));

    }

    private void registerInstituionView() {
        main.content.setSecondComponent(new InstitutionRegistrationMenu(main, LANDING_TAB));
    }

}
