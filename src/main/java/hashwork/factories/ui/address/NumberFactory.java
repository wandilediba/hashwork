package hashwork.factories.ui.address;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.address.Number;

/**
 * Created by garran on 2015/08/30.
 */
public class NumberFactory {
    public static Number getNumber(String numbers) {
        Number number = new Number.Builder()
                .id(KeyGenerator.getEntityId())
                .number(numbers).build();
        return number;
    }
}
