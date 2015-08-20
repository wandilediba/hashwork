/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.address.views.SuburbTab;

/**
 *
 * @author Garran
 */
public class AddressMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;
    
    public AddressMenu(MainLayout main, String tab) {
        this.main = main;
        
        VerticalLayout suburbTab = new VerticalLayout();
        suburbTab.setMargin(true);
        suburbTab.addComponent(new SuburbTab(main));
        
        

    }
}
