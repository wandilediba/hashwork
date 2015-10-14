package hashwork.app.facade;

import hashwork.services.people.Impl.*;
import hashwork.services.people.*;

/**
 * Created by DibaW on 10/6/2015.
 */
public class PersonFacade {

    public final static PersonService personService = new PersonServiceImpl();

    public final static PersonAddressService personAddress = new PersonAddressServiceImpl();
    public final static PersonAttachmentService personAttachement = new PersonAttachmentServiceImpl();
    public final static PersonBenefitsService personBenefit = new PersonBenefitsServiceImpl();
    public final static PersonBenefitsFundingSourceService personBenefitsFundingSource = new PersonBenefitsFundingSourceImpl();
    public final static PersonContactService personContact = new PersonContactServiceImpl();
    public final static PersonContinuinigEducationService personContinuingEducation = new PersonContinuiningEducationServiceImpl();
    public final static PersonDemographicsService personDemographics = new PersonDemographicsServiceImpl();
    public final static PersonEducationHistoryService PersonEducationHistory = new PersonEducationHistoryServiceImpl();
    public final static PersonEmployementHistoryService personEmploymentHistory = new PersonEmploymentHistoryServiceImpl();
    public final static PersonHiringDecisionService personHiringDecision = new PersonHiringDecisionServiceImpl();
    public final static PersonIdentityService personIdentity = new PersonIdentityServiceImpl();
    public final static PersonInterviewFeedbackService personInterviewFeedback = new PersonInterviewFeedbackServiceImpl();
    public final static PersonLanguageService personLanguage = new PersonLanguageServiceImpl();
    public final static PersonPositionService personPosition = new PersonPositionServiceImpl();
    public final static PersonRoleService personRole = new PersonRoleServiceImpl();
}
