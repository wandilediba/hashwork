package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.TitleList;

/**
 * Created by zamzam on 15/08/22.
 */
public class TitleListFactory {
    public static TitleList getTitleList(String title){
        TitleList titleList = new TitleList.Builder()
                .title(title)
                .build();
        return titleList;
    }
}
