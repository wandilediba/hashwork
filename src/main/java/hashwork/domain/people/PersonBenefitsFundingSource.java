package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonBenefitsFundingSource implements Serializable {
    private String id;
    private String personId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;
}
