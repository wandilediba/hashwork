/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.country;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 *
 * @author Garran
 */
public class CountryMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;
    
    public CountryMenu(MainLayout main, String tab) {
        this.main = main;
    }
}
