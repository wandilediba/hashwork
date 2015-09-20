package hashwork.app.facade;

import hashwork.services.payroll.ui.job.*;
import hashwork.services.payroll.ui.job.Impl.*;

/**
 * Created by zamzam on 15/09/15.
 */
public class JobFacade {
    public final static BenefitFrequencyService benefitFrequencyService = new BenefitFrequencyServiceImpl();
    public final static BenefitTypeService benefitTypeService = new BenefitTypeServiceImpl();
    public final static JobAdvertService jobAdvertService = new JobAdvertServiceImpl();
    public final static JobApplicantService jobApplicationService = new JobApplicantServiceImpl();
    public final static JobClassificationService jobClassificationService = new JobClassificationServiceImpl();
    public final static JobService jobService = new JobServiceImpl();
    public final static SalaryGradeService salaryGradeService = new SalaryGradeServiceImpl();
}
