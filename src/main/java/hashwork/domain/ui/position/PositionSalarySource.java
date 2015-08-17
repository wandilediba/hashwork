package hashwork.domain.ui.position;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionSalarySource implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String positionId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;
}
