package hashwork.client.content.system.office;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.education.views.CompetencyTab;
import hashwork.client.content.system.office.views.DepartmentTab;
import hashwork.client.content.system.office.views.OfficeTab;
import hashwork.client.content.system.office.views.OfficeTypeTab;

/**
 * Created by hashcode on 2015/08/18.
 */
public class OfficeMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public OfficeMenu(MainLayout main, String selectedTab) {
        this.main = main;

        VerticalLayout companyTab = new VerticalLayout();
        companyTab.setMargin(true);
        companyTab.addComponent(new CompetencyTab(main));

        VerticalLayout departmentTab = new VerticalLayout();
        departmentTab.setMargin(true);
        departmentTab.addComponent(new DepartmentTab(main));

        VerticalLayout officeTab = new VerticalLayout();
        officeTab.setMargin(true);
        officeTab.addComponent(new OfficeTab(main));

        VerticalLayout officeTypeTab = new VerticalLayout();
        officeTypeTab.setMargin(true);
        officeTypeTab.addComponent(new OfficeTypeTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(companyTab, "Office COMPANY", null);
        tab.addTab(departmentTab, "company DEPARTMENT", null);
        tab.addTab(officeTab, "OFFICE", null);
        tab.addTab(officeTypeTab, "Office TYPE", null);

        if (selectedTab.equals(OfficeTabValues.LANDING.name())) {
            tab.setSelectedTab(companyTab);
        } else if (selectedTab.equals(OfficeTabValues.DEPARTMENT.name())) {
            tab.setSelectedTab(departmentTab);
        } else if (selectedTab.equals(OfficeTabValues.OFFICE.name())) {
            tab.setSelectedTab(officeTab);
        } else if (selectedTab.equals(OfficeTabValues.OFFICETYPE.name())) {
            tab.setSelectedTab(officeTypeTab);
        }
        addComponent(tab);

    }
    }

