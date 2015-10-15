package hashwork.client.content.system.training;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.training.views.CourseCategoryTab;
import hashwork.client.content.system.training.views.TrainingInstitutionTab;

/**
 * Created by hashcode on 2015/08/18.
 */
public class TrainingMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public TrainingMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout courseCategoryTab = new VerticalLayout();
        courseCategoryTab.setMargin(true);
        courseCategoryTab.addComponent(new CourseCategoryTab(main));


        VerticalLayout trainingInstitutionTab = new VerticalLayout();
        trainingInstitutionTab.setMargin(true);
        trainingInstitutionTab.addComponent(new TrainingInstitutionTab(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(courseCategoryTab, "Course CATEGORY", null);
        tab.addTab(trainingInstitutionTab, "Training INSTITUTION", null);

        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(courseCategoryTab);
        } else if (selectedTab.equals("TRAINING")) {
            tab.setSelectedTab(trainingInstitutionTab);
        }
        addComponent(tab);
    }
}