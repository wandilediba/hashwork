package hashwork.client.content.system.utilities;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.utilities.views.*;

/**
 * Created by hashcode on 2015/08/18.
 */
public class UtilitiesMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public UtilitiesMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout statusTab = new VerticalLayout();
        statusTab.setMargin(true);
        statusTab.addComponent(new StatusTab(main));

        VerticalLayout funderTab = new VerticalLayout();
        funderTab.setMargin(true);
        funderTab.addComponent(new FunderTab(main));

        VerticalLayout currencyTab = new VerticalLayout();
        currencyTab.setMargin(true);
        currencyTab.addComponent(new CurrencyTab(main));

        VerticalLayout disciplineActionTypeListTab = new VerticalLayout();
        disciplineActionTypeListTab.setMargin(true);
        disciplineActionTypeListTab.addComponent(new DisciplineActionTypeListTab(main));

        VerticalLayout accidentTypeListTab = new VerticalLayout();
        accidentTypeListTab.setMargin(true);
        accidentTypeListTab.addComponent(new AccidentTypeListTab(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(disciplineActionTypeListTab, "Discipline  ACTION", null);
        tab.addTab(statusTab, "Status  LIST", null);
        tab.addTab(funderTab, "Funders LIST", null);
        tab.addTab(currencyTab, "Currencies  LIST", null);
        tab.addTab(accidentTypeListTab, "Accident Type  LIST", null);
        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(disciplineActionTypeListTab);
        } else if (selectedTab.equals("STATUS")) {
            tab.setSelectedTab(statusTab);
        } else if (selectedTab.equals("FUNDER")) {
            tab.setSelectedTab(funderTab);
        } else if (selectedTab.equals("CURRENCY")) {
            tab.setSelectedTab(currencyTab);
        } else if (selectedTab.equals("ACCIDENT")) {
            tab.setSelectedTab(accidentTypeListTab);
        }
        addComponent(tab);
    }

}


