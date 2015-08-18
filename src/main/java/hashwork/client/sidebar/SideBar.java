package hashwork.client.sidebar;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import hashwork.client.content.MainLayout;
import hashwork.client.sidebar.trees.*;

/**
 * Created by hashcode on 2015/08/16.
 */
public class SideBar extends Accordion {
    private final MainLayout main;
    public static final String HOME_CONTENT = "HOME ";
    public static final String MANAGE_EMPLOYEES = "Manage EMPLOYEES ";
    public static final String MANAGE_REPORTS = "Manage REPORTS";
    public static final String SETUP_SYSTEM = "Setup SYSTEM";
    public static final String MANAGE_USERS = "Manage USERS";
    public static final String MANAGE_TRAINING = " Manage TRAINING";
    public static final String MANAGE_POSITIONS = "Manage POSITIONS";
    public static final String EMPLOYEE_SELF_SERVICE = "Employee SELF SERVICE";
    public static final String MANAGE_JOB_APPLICATIONS = "Manage JOB APPLICATIONS";
    public static final String MANAGE_YOUR_ACCOUNT = "Manage YOUR ACCOUNT";
    public static final String DECISION_CENTER = "Decision CENTER";
    public static final String USERS_PROFILE = "Users PROFILE";

    public SideBar(MainLayout main) {
        this.main = main;
        setSizeFull();
        addStyleName(ValoTheme.ACCORDION_BORDERLESS);
        setHeight("600px");
        //Configure Manage People Menu
        VerticalLayout homeMenu = new VerticalLayout();
        HomeTree homeTree = new HomeTree(main);
        homeMenu.addComponent(homeTree);

        VerticalLayout profileMenu = new VerticalLayout();
        ProfileTree profileTree = new ProfileTree(main);
        profileMenu.addComponent(profileTree);

        VerticalLayout employeesMenu = new VerticalLayout();
        EmployeesTree employeesTree = new EmployeesTree(main);
        employeesMenu.addComponent(employeesTree);

        VerticalLayout positionMenu = new VerticalLayout();
        PositionsTree positionsTree = new PositionsTree(main);
        positionMenu.addComponent(positionsTree);

        VerticalLayout reportsMenu = new VerticalLayout();
        ReportsTree reportsTree = new ReportsTree(main);
        reportsMenu.addComponent(reportsTree);

        VerticalLayout systemsMenu = new VerticalLayout();
        SystemsTree systemsTree = new SystemsTree(main);
        systemsMenu.addComponent(systemsTree);

        VerticalLayout trainingMenu = new VerticalLayout();
        TrainingTree trainingTree = new TrainingTree(main);
        trainingMenu.addComponent(trainingTree);

        VerticalLayout applicationsMenu = new VerticalLayout();
        ApplicationsTree applicationsTree = new ApplicationsTree(main);
        applicationsMenu.addComponent(applicationsTree);

        VerticalLayout selfServiceMenu = new VerticalLayout();
        SelfServiceTree selfServiceTree = new SelfServiceTree(main);
        selfServiceMenu.addComponent(selfServiceTree);

        VerticalLayout accountsMenu = new VerticalLayout();
        AccountTree accountTree = new AccountTree(main);
        accountsMenu.addComponent(accountTree);

        VerticalLayout usersMenu = new VerticalLayout();
        UsersTree usersTree = new UsersTree(main);
        usersMenu.addComponent(usersTree);


        VerticalLayout decisionMenu = new VerticalLayout();
        DecisionTree decisionTree = new DecisionTree(main);
        decisionMenu.addComponent(decisionTree);

        // Add the components as tabs in the Accordion.
        addTab(homeMenu, HOME_CONTENT, null);
        addTab(profileMenu, USERS_PROFILE, null);
        addTab(employeesMenu, MANAGE_EMPLOYEES, null);
        addTab(selfServiceMenu, EMPLOYEE_SELF_SERVICE, null);
        addTab(trainingMenu, MANAGE_TRAINING, null);
        addTab(decisionMenu, DECISION_CENTER, null);

        addTab(applicationsMenu, MANAGE_JOB_APPLICATIONS, null);

        addTab(positionMenu, MANAGE_POSITIONS, null);
        addTab(accountsMenu, MANAGE_YOUR_ACCOUNT, null);
        addTab(reportsMenu, MANAGE_REPORTS, null);
        addTab(usersTree, MANAGE_USERS, null);
        addTab(systemsMenu, SETUP_SYSTEM, null);

    }
}
