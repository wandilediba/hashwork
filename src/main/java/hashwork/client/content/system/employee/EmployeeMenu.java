/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.employee.views.EmployeeNumberTab;
import hashwork.client.content.system.employee.views.EmployeeTypeTab;
import hashwork.client.content.system.employee.views.HireDateTab;
import hashwork.client.content.system.employee.views.IdentificationNumberTab;
import hashwork.client.content.system.employee.views.NameTab;
import hashwork.client.content.system.employee.views.SurnameTab;

/**
 *
 * @author Garran
 */
public class EmployeeMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;
    
    public EmployeeMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout employeeNumberTab = new VerticalLayout();
        employeeNumberTab.setMargin(true);
        employeeNumberTab.addComponent(new EmployeeNumberTab(main));

        VerticalLayout employeeTypeTab = new VerticalLayout();
        employeeTypeTab.setMargin(true);
        employeeTypeTab.addComponent(new EmployeeTypeTab(main));

        VerticalLayout hireDateTab = new VerticalLayout();
        hireDateTab.setMargin(true);
        hireDateTab.addComponent(new HireDateTab(main));

        VerticalLayout identificationNumberTab = new VerticalLayout();
        identificationNumberTab.setMargin(true);
        identificationNumberTab.addComponent(new IdentificationNumberTab(main));

        VerticalLayout nameTab = new VerticalLayout();
        nameTab.setMargin(true);
        nameTab.addComponent(new NameTab(main));

        VerticalLayout surnameTab = new VerticalLayout();
        surnameTab.setMargin(true);
        surnameTab.addComponent(new SurnameTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(employeeNumberTab, "Employee Number", null);
        tab.addTab(employeeTypeTab, "Employee Type", null);
        tab.addTab(hireDateTab, "Hire Date", null);
        tab.addTab(identificationNumberTab, "Identification Number", null);
        tab.addTab(nameTab, "Name", null);
        tab.addTab(surnameTab, "Surname", null);

        if (selectedTab.equals("EMPLOYEENUMBER")) {
            tab.setSelectedTab(employeeNumberTab);
        } else if (selectedTab.equals("EMPLOYEETYPE")) {
            tab.setSelectedTab(employeeTypeTab);
        } else if (selectedTab.equals("HIREDATE")) {
            tab.setSelectedTab(hireDateTab);
        } else if (selectedTab.equals("IDENTIFICATIONNUMBER")) {
            tab.setSelectedTab(identificationNumberTab);
        } else if (selectedTab.equals("NAME")) {
            tab.setSelectedTab(nameTab);
        } else if (selectedTab.equals("SURNAME")) {
            tab.setSelectedTab(surnameTab);
        }

        addComponent(tab);
    }
}