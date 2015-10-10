package hashwork.client.content.system.education;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.education.views.*;

/**
 * Created by hashcode on 2015/08/18.
 */
public class EducationMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public EducationMenu(MainLayout main, String selectedTab) {
        this.main = main;

        VerticalLayout competencyTab = new VerticalLayout();
        competencyTab.setMargin(true);
        competencyTab.addComponent(new CompetencyTab(main));

        VerticalLayout competencyTypeTab = new VerticalLayout();
        competencyTypeTab.setMargin(true);
        competencyTypeTab.addComponent(new CompetencyTypeTab(main));

        VerticalLayout degreeTab = new VerticalLayout();
        degreeTab.setMargin(true);
        degreeTab.addComponent(new DegreeTab(main));

        VerticalLayout educationType = new VerticalLayout();
        educationType.setMargin(true);
        educationType.addComponent(new EducationTypeTab(main));

        VerticalLayout evaluationTab = new VerticalLayout();
        evaluationTab.setMargin(true);
        evaluationTab.addComponent(new EvaluationTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(competencyTab, "COMPETENCY", null);
        tab.addTab(competencyTypeTab, "Competency TYPE", null);
        tab.addTab(degreeTab, "Education DEGREE", null);
        tab.addTab(educationType, "Education TYPE", null);
        tab.addTab(evaluationTab, "Education EVALUATION", null);
        if (selectedTab.equals(EducationTabValues.LANDING.name())) {
            tab.setSelectedTab(competencyTab);
        } else if (selectedTab.equals(EducationTabValues.COMPETENCY.name())) {
            tab.setSelectedTab(competencyTypeTab);
        } else if (selectedTab.equals(EducationTabValues.COMPETENCYTYPE.name())) {
            tab.setSelectedTab(degreeTab);
        } else if (selectedTab.equals(EducationTabValues.DEGREE.name())) {
            tab.setSelectedTab(educationType);
        } else if (selectedTab.equals(EducationTabValues.
                EDUCATIONTYPE.name())) {
            tab.setSelectedTab(evaluationTab);
        }
        addComponent(tab);

    }


    }