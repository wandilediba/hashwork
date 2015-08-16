package hashwork.domain.ui.training;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseFundingSource implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;
}
