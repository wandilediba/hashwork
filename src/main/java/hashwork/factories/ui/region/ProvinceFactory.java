package hashwork.factories.ui.region;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.region.Province;

/**
 * Created by garran on 2015/09/13.
 */
public class ProvinceFactory {
    public static Province getProvince(String provinces) {
        Province province = new Province.Builder()
                .id(KeyGenerator.getEntityId())
                .province(provinces).build();
        return province;
    }
}
