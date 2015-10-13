package hashwork.client.content.training.registration;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.registration.views.CourseRequestTab;
import hashwork.client.content.training.registration.views.CourseScheduledTab;
import hashwork.client.content.training.registration.views.RegisterInstitutionTab;

/**
 * Created by hashcode on 2015/10/08.
 */
public class InstitutionRegistrationMenu extends VerticalLayout {

    private MainLayout main;
    private TabSheet tab;

    public InstitutionRegistrationMenu(MainLayout app, String selectedTab) {
        main = app;

        VerticalLayout registerInstirtutionTab = new VerticalLayout();
        registerInstirtutionTab.setMargin(true);
        registerInstirtutionTab.addComponent(new RegisterInstitutionTab(main));

        VerticalLayout courseRequestTab = new VerticalLayout();
        courseRequestTab.setMargin(true);
        courseRequestTab.addComponent(new CourseRequestTab(main));

        VerticalLayout courseOfferingTab = new VerticalLayout();
        courseOfferingTab.setMargin(true);
        courseOfferingTab.addComponent(new CourseScheduledTab(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(registerInstirtutionTab, "Register INSTITUTION", null);
        tab.addTab(courseRequestTab, "Request COURSE", null);
        tab.addTab(courseOfferingTab, "Course SCHEDULES", null);


        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(registerInstirtutionTab);
        } else if (selectedTab.equals("REQUEST")) {
            tab.setSelectedTab(courseRequestTab);
        } else if (selectedTab.equals("SCHEDULES")) {
            tab.setSelectedTab(courseOfferingTab);
        }
        addComponent(tab);
    }
}
