package hashwork.factories.ui.City;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.City.City;

/**
 * Created by garran on 2015/09/05.
 */
public class CityFactory {
    public static City getCity(String value) {
        City city = new City.Builder()
                .id(KeyGenerator.getEntityId())
                .city(value).build();
        return city;
    }
}
