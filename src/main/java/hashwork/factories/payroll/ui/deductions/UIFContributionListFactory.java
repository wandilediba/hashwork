package hashwork.factories.payroll.ui.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.deductions.UIFContributionList;

import java.math.BigDecimal;

/**
 * Created by zamzam on 15/09/05.
 */
public class UIFContributionListFactory {
    public static UIFContributionList getUIFContributionList(String code,
                                                             BigDecimal uifPercentContribution) {
        UIFContributionList uifContributionList = new UIFContributionList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .code(code)
                .uifPercentContribution(uifPercentContribution).build();
        return uifContributionList;
    }
}
