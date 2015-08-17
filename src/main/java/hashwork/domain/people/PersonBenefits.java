package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonBenefits implements Serializable {
    private String id;
    private String personId;

    private String benefitTypeId;
    private List<String> PersonBenefitsFundingSourceIds;

    private String currencyId;
    private Date startDate;
    private Date endDate;
    private String benefitFrequencyId;
    private BigDecimal amount;
}
