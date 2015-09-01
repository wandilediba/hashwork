package hashwork.factories.ui.country;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.country.Country;

/**
 * Created by garran on 2015/09/01.
 */
public class CountryFactory {
    public static Country getSuburb(String countries) {
        Country country = new Country.Builder()
                .id(KeyGenerator.getEntityId())
                .country(countries).build();
        return country;

    }
}
