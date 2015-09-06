/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.address.views.NumberTab;
import hashwork.client.content.system.address.views.PostalCodeTab;
import hashwork.client.content.system.address.views.StreetNameTab;
import hashwork.client.content.system.address.views.SuburbTab;

/**
 *
 * @author Garran
 */
public class AddressMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;
    
    public AddressMenu(MainLayout main, String selectedTab) {
        this.main = main;
        
        VerticalLayout suburbTab = new VerticalLayout();
        suburbTab.setMargin(true);
        suburbTab.addComponent(new SuburbTab(main));
        
        VerticalLayout numberTab = new VerticalLayout();
        numberTab.setMargin(true);
        numberTab.addComponent(new NumberTab(main));
        
        VerticalLayout postalCodeTab = new VerticalLayout();
        postalCodeTab.setMargin(true);
        postalCodeTab.addComponent(new PostalCodeTab(main));
        
        VerticalLayout streetNameTab = new VerticalLayout();
        streetNameTab.setMargin(true);
        streetNameTab.addComponent(new StreetNameTab(main));
        
        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        tab.addTab(suburbTab, "Suburb", null);
        tab.addTab(numberTab, "Number", null);
        tab.addTab(postalCodeTab, "Postal Code", null);
        tab.addTab(streetNameTab, "Street Name", null);

        if (selectedTab.equals("SUBURB")) {
            tab.setSelectedTab(suburbTab);
        } else if (selectedTab.equals("NUMBER")) {
            tab.setSelectedTab(numberTab);
        } else if (selectedTab.equals("POSTALCODE")) {
            tab.setSelectedTab(postalCodeTab);
        } else if (selectedTab.equals("STREETNAME")) {
            tab.setSelectedTab(streetNameTab);
        } 
        
        addComponent(tab);
    }
}