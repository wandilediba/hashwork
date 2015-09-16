package hashwork.client.sidebar;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import hashwork.client.content.MainLayout;
import hashwork.client.sidebar.trees.*;

/**
 * Created by hashcode on 2015/08/16.
 */
public class SideBar extends VerticalLayout {
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
    final Accordion accordion = new Accordion();


    public SideBar(MainLayout main) {
        this.main = main;
        setSizeFull();
        setMargin(true);

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

        accordion.addTab(homeMenu, HOME_CONTENT, FontAwesome.HOME);
        accordion.addTab(profileMenu, USERS_PROFILE, FontAwesome.USER);
        accordion.addTab(employeesMenu, MANAGE_EMPLOYEES, FontAwesome.BUILDING);
        accordion.addTab(selfServiceMenu, EMPLOYEE_SELF_SERVICE, FontAwesome.KEYBOARD_O).setStyleName(ValoTheme.LABEL_COLORED);
        accordion.addTab(trainingMenu, MANAGE_TRAINING, FontAwesome.UNIVERSITY);
        accordion.addTab(decisionMenu, DECISION_CENTER, FontAwesome.KEY);

        accordion.addTab(applicationsMenu, MANAGE_JOB_APPLICATIONS, FontAwesome.SEARCH_PLUS);

        accordion.addTab(positionMenu, MANAGE_POSITIONS, FontAwesome.BUILDING_O);
        accordion.addTab(accountsMenu, MANAGE_YOUR_ACCOUNT, FontAwesome.GEAR);
        accordion.addTab(reportsMenu, MANAGE_REPORTS, FontAwesome.BAR_CHART_O);
        accordion.addTab(usersTree, MANAGE_USERS, FontAwesome.USERS);
        accordion.addTab(systemsMenu, SETUP_SYSTEM, FontAwesome.GEARS);
        addComponent(accordion);
    }
}
