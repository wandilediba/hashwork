package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.demographics.DemographicsMenu;
import hashwork.client.content.system.education.EducationMenu;
import hashwork.client.content.system.jobs.JobsMenu;
import hashwork.client.content.system.locations.LocationMenu;
import hashwork.client.content.system.office.OfficeMenu;
import hashwork.client.content.system.positions.PositionsMenu;
import hashwork.client.content.system.training.TrainingMenu;
import hashwork.client.content.system.utilities.UtilitiesMenu;

/**
 * Created by hashcode on 2015/08/17.
 */
public class SystemsTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    private static final String LANDING_TAB = "LANDING";
    public static final Object SETUP_LOCATIONS = "Setup LOCATIONS";
    public static final Object SETUP_DEMOGRAPHICS = "Setup DEMOGRAPHICS";
    public static final Object SETUP_EDUCATION = "Setup EDUCATION";
    public static final Object SETUP_JOBS = "Setup JOBS";
    public static final Object SETUP_POSITIONS = "Setup POSITIONS";
    public static final Object SETUP_TRAINING = "Setup TRAINING";
    public static final Object SETUP_UTILS = "Setup UTILITIES";
    public static final Object SETUP_OFFICE = "Setup OFFICE";



    public SystemsTree(MainLayout main) {
        this.main = main;
        //add Items to Menu
        addItem(SETUP_LOCATIONS);
        addItem(SETUP_OFFICE);
        addItem(SETUP_DEMOGRAPHICS);
        addItem(SETUP_EDUCATION);
        addItem(SETUP_JOBS);
        addItem(SETUP_POSITIONS);
        addItem(SETUP_TRAINING);
        addItem(SETUP_UTILS);


        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);


    }
    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (SETUP_LOCATIONS.equals(itemId)) {
                locationView();
            } else if (SETUP_OFFICE.equals(itemId)) {
                officeView();
            } else if (SETUP_DEMOGRAPHICS.equals(itemId)) {
                demographicsView();
            } else if (SETUP_EDUCATION.equals(itemId)) {
                educationView();
            } else if (SETUP_JOBS.equals(itemId)) {
                jobsView();
            } else if (SETUP_POSITIONS.equals(itemId)) {
                positionView();
            } else if (SETUP_TRAINING.equals(itemId)) {
                trainingView();
            } else if (SETUP_UTILS.equals(itemId)) {
                utilsView();
            }
        }
    }

    private void educationView() {
        main.content.setSecondComponent(new EducationMenu(main, LANDING_TAB));
    }

    private void locationView() {
        main.content.setSecondComponent(new LocationMenu(main, LANDING_TAB));
    }

    private void demographicsView() {
        main.content.setSecondComponent(new DemographicsMenu(main, LANDING_TAB));
    }

    private void jobsView() {
        main.content.setSecondComponent(new JobsMenu(main, LANDING_TAB));
    }

    private void positionView() {
        main.content.setSecondComponent(new PositionsMenu(main, LANDING_TAB));
    }

    private void trainingView() {
        main.content.setSecondComponent(new TrainingMenu(main, LANDING_TAB));
    }

    private void utilsView() {
        main.content.setSecondComponent(new UtilitiesMenu(main, LANDING_TAB));
    }

    private void officeView() {
        main.content.setSecondComponent(new OfficeMenu(main, LANDING_TAB));
    }
}
