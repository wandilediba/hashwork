package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonPosition implements Serializable {
    private String id;
    private String personId;
    private String positionId;
    private Date startDate;
    private Date endDate;
    private String statusId;
    private BigDecimal salary;
    private String currencyId;
    private Date salaryDate;
    private String changeReasonId;

}
