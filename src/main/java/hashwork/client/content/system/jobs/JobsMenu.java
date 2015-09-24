package hashwork.client.content.system.jobs;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.jobs.views.*;

/**
 * Created by hashcode on 2015/08/18.
 */
public class JobsMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public JobsMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout benefityFrequencyTab = new VerticalLayout();
        benefityFrequencyTab.setMargin(true);
        benefityFrequencyTab.addComponent(new BenefitFrequencyTab(main));

        VerticalLayout benefitTypeTab = new VerticalLayout();
        benefitTypeTab.setMargin(true);
        benefitTypeTab.addComponent(new BenefitTypeTab(main));

        VerticalLayout jobClassificationTab = new VerticalLayout();
        jobClassificationTab.setMargin(true);
        jobClassificationTab.addComponent(new JobClassificationTab(main));

        VerticalLayout jobTab = new VerticalLayout();
        jobTab.setMargin(true);
        jobTab.addComponent(new JobTab(main));

        VerticalLayout salaryGradeTab = new VerticalLayout();
        salaryGradeTab.setMargin(true);
        salaryGradeTab.addComponent(new SalaryGradeTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(jobClassificationTab, "Job CLASSIFICATION", null);
        tab.addTab(benefityFrequencyTab, "Benefit FREQUENCY", null);
        tab.addTab(benefitTypeTab, "Benefit TYPE", null);
        tab.addTab(jobTab, "Job", null);
        tab.addTab(salaryGradeTab, "Salary GRADE", null);
        if (selectedTab.equals(JobsTabValues.LANDING.name())) {
            tab.setSelectedTab(jobClassificationTab);
        } else if (selectedTab.equals(JobsTabValues.BENEFITFREQUENCY.name())) {
            tab.setSelectedTab(benefityFrequencyTab);
        } else if (selectedTab.equals(JobsTabValues.BENEFITTYPE.name())) {
            tab.setSelectedTab(benefitTypeTab);
        } else if (selectedTab.equals(JobsTabValues.JOB.name())) {
            tab.setSelectedTab(jobTab);
        } else if (selectedTab.equals(JobsTabValues.SALARYGRADE.name())) {
            tab.setSelectedTab(salaryGradeTab);
        }
        addComponent(tab);

    }
}
