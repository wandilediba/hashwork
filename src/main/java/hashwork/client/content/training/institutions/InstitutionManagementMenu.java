package hashwork.client.content.training.institutions;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.institutions.views.AssessParticipantTab;
import hashwork.client.content.training.institutions.views.CreateCourseTab;
import hashwork.client.content.training.institutions.views.ScheduleCourseTab;
import hashwork.client.content.training.institutions.views.TrainingInstitutionTrainerTab;

/**
 * Created by hashcode on 2015/10/08.
 */
public class InstitutionManagementMenu extends VerticalLayout {

    private MainLayout main;
    private TabSheet tab;

    public InstitutionManagementMenu(MainLayout app, String selectedTab) {
        main = app;

        VerticalLayout addTrainersTab = new VerticalLayout();
        addTrainersTab.setMargin(true);
        addTrainersTab.addComponent(new TrainingInstitutionTrainerTab(main));

        VerticalLayout scheduleCoursesTab = new VerticalLayout();
        scheduleCoursesTab.setMargin(true);
        scheduleCoursesTab.addComponent(new ScheduleCourseTab(main));

        VerticalLayout assessParticipants = new VerticalLayout();
        assessParticipants.setMargin(true);
        assessParticipants.addComponent(new AssessParticipantTab(main));

        VerticalLayout createCourses = new VerticalLayout();
        createCourses.setMargin(true);
        createCourses.addComponent(new CreateCourseTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(addTrainersTab, "Add TRAINERS", null);
        tab.addTab(createCourses, "Create COURSE", null);
        tab.addTab(scheduleCoursesTab, "Schedule COURSE", null);

        tab.addTab(assessParticipants, "Participants ASSESSMENT", null);

        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(addTrainersTab);
        } else if (selectedTab.equals("SCHEDULE")) {
            tab.setSelectedTab(scheduleCoursesTab);
        } else if (selectedTab.equals("PARTICIPANTS")) {
            tab.setSelectedTab(assessParticipants);
        } else if (selectedTab.equals("CREATE")) {
            tab.setSelectedTab(createCourses);
        }

        addComponent(tab);
    }
}