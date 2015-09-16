package hashwork.client.content.system.locations;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.locations.views.*;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LocationMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public LocationMenu(MainLayout main, String selectedTab) {
        this.main = main;
        VerticalLayout locationTab = new VerticalLayout();
        locationTab.setMargin(true);
        locationTab.addComponent(new LocationTab(main));

        VerticalLayout addressTypeTab = new VerticalLayout();
        addressTypeTab.setMargin(true);
        addressTypeTab.addComponent(new AddressTypeTab(main));

        VerticalLayout contactListTab = new VerticalLayout();
        contactListTab.setMargin(true);
        contactListTab.addComponent(new ContactListTab(main));

        VerticalLayout locationTypeTab = new VerticalLayout();
        locationTypeTab.setMargin(true);
        locationTypeTab.addComponent(new LocationTypeTab(main));

        VerticalLayout registrationBodyTab = new VerticalLayout();
        registrationBodyTab.setMargin(true);
        registrationBodyTab.addComponent(new RegistrationBodyTab(main));


        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(locationTypeTab, "Location TYPES", null);
        tab.addTab(locationTab, "Geographical LOCATIONS", null);
        tab.addTab(addressTypeTab, "Address TYPES", null);
        tab.addTab(contactListTab, "Contact LIST", null);
        tab.addTab(registrationBodyTab, "Registration BODY", null);
        if (selectedTab.equals("LANDING")) {
            tab.setSelectedTab(locationTypeTab);
        } else if (selectedTab.equals("LOCATION")) {
            tab.setSelectedTab(locationTab);
        } else if (selectedTab.equals("ADDRESSTYPE")) {
            tab.setSelectedTab(addressTypeTab);
        } else if (selectedTab.equals("CONTACTLIST")) {
            tab.setSelectedTab(contactListTab);
        } else if (selectedTab.equals("REGISTRATIONBODY")) {
            tab.setSelectedTab(registrationBodyTab);
        }
        addComponent(tab);
    }

}


