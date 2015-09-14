package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.PositionSalarySource;

import java.math.BigDecimal;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionSalarySourceFactory {
    public static PositionSalarySource getPositionSalarySource(String positionId, String funderId, BigDecimal amount, String currencyId) {
        PositionSalarySource positionSalarySource = new PositionSalarySource.Builder()
                .id(KeyGenerator.getEntityId())
                .positionId(positionId)
                .funderId(funderId)
                .amount(amount)
                .currencyId(currencyId)
                .build();
        return positionSalarySource;
    }
}
