package hashwork.client.content.system.positions;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.positions.views.DepartureReasonTab;
import hashwork.client.content.system.positions.views.PositionTab;
import hashwork.client.content.system.positions.views.PositionTypeTab;

/**
 * Created by hashcode on 2015/08/18.
 */
public class PositionsMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public PositionsMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout depatureReasonTab = new VerticalLayout();
        depatureReasonTab.setMargin(true);
        depatureReasonTab.addComponent(new DepartureReasonTab(main));

        VerticalLayout positionTab = new VerticalLayout();
        positionTab.setMargin(true);
        positionTab.addComponent(new PositionTab(main));

        VerticalLayout positionTypeTab = new VerticalLayout();
        positionTypeTab.setMargin(true);
        positionTypeTab.addComponent(new PositionTypeTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(depatureReasonTab, "Departure REASONS", null);
        tab.addTab(positionTab, "Positions", null);
        tab.addTab(positionTypeTab, "Position TYPES", null);

        if (selectedTab.equals(PositionTabValues.LANDING.name())) {
            tab.setSelectedTab(positionTypeTab);
        } else if (selectedTab.equals(PositionTabValues.POSITION.name())) {
            tab.setSelectedTab(positionTab);
        } else if (selectedTab.equals(PositionTabValues.DEPARTUREREASON.name())) {
            tab.setSelectedTab(depatureReasonTab);
        }
        addComponent(tab);

    }
}
