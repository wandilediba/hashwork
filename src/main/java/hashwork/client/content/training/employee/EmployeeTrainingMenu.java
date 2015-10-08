package hashwork.client.content.training.employee;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.employee.views.*;

/**
 * Created by hashcode on 2015/10/08.
 */
public class EmployeeTrainingMenu extends VerticalLayout {

    private MainLayout main;
    private TabSheet tab;

    public EmployeeTrainingMenu(MainLayout app, String selectedTab) {
        main = app;

        VerticalLayout requestTrainingTab = new VerticalLayout();
        requestTrainingTab.setMargin(true);
        requestTrainingTab.addComponent(new RequestTrainingTab(main));

        VerticalLayout enrollmentTab = new VerticalLayout();
        enrollmentTab.setMargin(true);
        enrollmentTab.addComponent(new EnrollmentTab(main));

        VerticalLayout approvedRequestsTab = new VerticalLayout();
        approvedRequestsTab.setMargin(true);
        approvedRequestsTab.addComponent(new ApprovedRequestTab(main));

        VerticalLayout rejectedRequestsTab = new VerticalLayout();
        rejectedRequestsTab.setMargin(true);
        rejectedRequestsTab.addComponent(new RejectedRequestTab(main));

        VerticalLayout pendingRequestTab = new VerticalLayout();
        pendingRequestTab.setMargin(true);
        pendingRequestTab.addComponent(new PendingRequestTab(main));

        VerticalLayout fullfiledRequestTab = new VerticalLayout();
        fullfiledRequestTab.setMargin(true);
        fullfiledRequestTab.addComponent(new FullfilledRequestTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(requestTrainingTab, "Request TRAINING", null);
        tab.addTab(enrollmentTab, "Enroll PARTICIPANTS", null);
        tab.addTab(pendingRequestTab, "Pending REQUESTS", null);
        tab.addTab(approvedRequestsTab, "Approved REQUESTS", null);
        tab.addTab(rejectedRequestsTab, "Rejected REQUESTS", null);
        tab.addTab(fullfiledRequestTab, "Fullfilled REQUESTS", null);

        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(requestTrainingTab);
        } else if (selectedTab.equals("SCHEDULED")) {
            tab.setSelectedTab(enrollmentTab);
        } else if (selectedTab.equals("APPROVED")) {
            tab.setSelectedTab(approvedRequestsTab);
        } else if (selectedTab.equals("REJECTED")) {
            tab.setSelectedTab(rejectedRequestsTab);
        } else if (selectedTab.equals("PENDING")) {
            tab.setSelectedTab(pendingRequestTab);
        } else if (selectedTab.equals("FULLFILED")) {
            tab.setSelectedTab(fullfiledRequestTab);
        }
        addComponent(tab);
    }
}
