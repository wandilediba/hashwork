package hashwork.factories.ui.util;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.util.Currency;

/**
 * Created by DibaW on 9/7/2015.
 */
public class CurrencyFactory {

    public static Currency getCurrency(String name, String code,String  symbol){

        Currency currency = new Currency.Builder()
                             .id(KeyGenerator.getEntityId())
                             .name(name)
                             .symbol(symbol)
                             .code(code)
                             .build();

        return currency;
    }
}
