package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class ApplicationsTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    public static final Object JOB_APPLICATIONS = "Job APPLICATIONS";
    public static final Object SUBMIT_APPLICATION = "Manage APPLICATION";
    public static final Object JOB_ADVERTS = "Job Adverts";
    private static final String LANDING_TAB = "LANDING";

    public ApplicationsTree(MainLayout main) {
        this.main = main;
        addItem(JOB_ADVERTS);
        addItem(SUBMIT_APPLICATION);
        addItem(JOB_APPLICATIONS);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void submitView() {
//        main.content.setSecondComponent(new  SubmitApplicationMenu(main, LANDING_TAB));
    }

    private void applicantsView() {
//        main.content.setSecondComponent(new ApplicantsMenu(main, LANDING_TAB));
    }

    private void advertsView() {
//        main.content.setSecondComponent(new AdvertsMenu(main, LANDING_TAB));
    }
}
