package hashwork.factories.ui.region;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.region.Province;

/**
 * Created by garran on 2015/09/01.
 */
public class ProvinceFactory {
    public static Province getSuburb(String provinces) {
        Province province = new Province.Builder()
                .id(KeyGenerator.getEntityId())
                .province(provinces).build();
        return province;
    }
}
