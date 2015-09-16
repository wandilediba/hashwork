package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CourseFundingSource;

import java.math.BigDecimal;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseFundingSourceFactory {
    public static CourseFundingSource getCourseFundingSource(String courseId, String funderId, BigDecimal amount, String currencyId) {
        CourseFundingSource courseFundingSource = new CourseFundingSource.Builder()
                .id(KeyGenerator.getEntityId())
                .courseId(courseId)
                .funderid(funderId)
                .amount(amount)
                .currencyId(currencyId)
                .build();
        return courseFundingSource;
    }
}
