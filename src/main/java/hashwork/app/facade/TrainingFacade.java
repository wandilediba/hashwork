package hashwork.app.facade;

import hashwork.services.ui.training.*;
import hashwork.services.ui.training.Impl.*;

/**
 * Created by garran on 2015/09/13.
 */
public class TrainingFacade {

    public final static CompetencyEvaluationService competencyEvaluationService = new CompetencyEvaluationServiceImpl();
    public final static CompetencyRequestAggregateService competencyRequestAggregateService = new CompetencyRequestAggregateServiceImpl();
    public final static CompetencyRequestService competencyRequestService = new CompetencyRequestServiceImpl();
    public final static ContinuingEducationCourseService continuingEducationCourseService = new ContinuingEducationCourseServiceImpl();
    public final static CourseCategoryService courseCategoryService = new CourseCategoryServiceImpl();
    public final static CourseCompetenciesService courseCompetenciesService = new CourseCompetenciesServiceImpl();
    public final static CourseFundingSourceService courseFundingSourceService = new CourseFundingSourceServiceImpl();
    public final static CourseRequestService courseRequestService = new CourseRequestServiceImpl();
    public final static CourseService courseService = new CourseServiceImpl();
    public final static ScheduledCourseEvaluationService scheduledCourseEvaluationService = new ScheduledCourseEvaluationServiceImpl();
    public final static ScheduledCourseInstructorService scheduledCourseInstructorService = new ScheduledCourseInstructorServiceImpl();
    public final static ScheduledCourseRequestorService scheduledCourseRequestorService = new ScheduledCourseRequestorServiceImpl();
    public final static ScheduledCourseService scheduledCourseService = new ScheduledCourseServiceImpl();
    public final static TrainingInstitutionService trainingInstitutionService = new TrainingInstitutionServiceImpl();
    public final static TrainingInstitutionTrainerService trainingInstitutionTrainerService = new TrainingInstitutionTrainerServiceImpl();

}
