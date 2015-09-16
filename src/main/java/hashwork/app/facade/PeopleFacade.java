/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.app.facade;

import hashwork.services.people.Impl.PersonAddressServiceImpl;
import hashwork.services.people.Impl.PersonAttachmentServiceImpl;
import hashwork.services.people.Impl.PersonBenefitsFundingSourceImpl;
import hashwork.services.people.Impl.PersonBenefitsServiceImpl;
import hashwork.services.people.Impl.PersonContactServiceImpl;
import hashwork.services.people.Impl.PersonContinuiningEducationServiceImpl;
import hashwork.services.people.Impl.PersonDemographicsServiceImpl;
import hashwork.services.people.Impl.PersonEducationHistoryServiceImpl;
import hashwork.services.people.Impl.PersonEmploymentHistoryServiceImpl;
import hashwork.services.people.Impl.PersonHiringDecisionServiceImpl;
import hashwork.services.people.Impl.PersonIdentityServiceImpl;
import hashwork.services.people.Impl.PersonInterviewFeedbackServiceImpl;
import hashwork.services.people.Impl.PersonLanguageServiceImpl;
import hashwork.services.people.Impl.PersonPositionServiceImpl;
import hashwork.services.people.Impl.PersonRoleServiceImpl;
import hashwork.services.people.Impl.PersonServiceImpl;
import hashwork.services.people.PersonAddressService;
import hashwork.services.people.PersonAttachmentService;
import hashwork.services.people.PersonBenefitsFundingSourceService;
import hashwork.services.people.PersonBenefitsService;
import hashwork.services.people.PersonContactService;
import hashwork.services.people.PersonContinuinigEducationService;
import hashwork.services.people.PersonDemographicsService;
import hashwork.services.people.PersonEducationHistoryService;
import hashwork.services.people.PersonEmployementHistoryService;
import hashwork.services.people.PersonHiringDecisionService;
import hashwork.services.people.PersonIdentityService;
import hashwork.services.people.PersonInterviewFeedbackService;
import hashwork.services.people.PersonLanguageService;
import hashwork.services.people.PersonPositionService;
import hashwork.services.people.PersonRoleService;
import hashwork.services.people.PersonService;
import hashwork.services.ui.location.Impl.AddressTypeServiceImpl;

/**
 *
 * @author BKLAAS1
 */
public class PeopleFacade {
    
    public final static PersonAddressService contactListService = new PersonAddressServiceImpl();
    public final static PersonAttachmentService personAttachmentService = new PersonAttachmentServiceImpl();
    public final static PersonBenefitsFundingSourceService personBenefitsFundingSourceService = new PersonBenefitsFundingSourceImpl();
    public final static PersonBenefitsService personBenefitsService = new PersonBenefitsServiceImpl();
    public final static PersonContactService personContactService = new PersonContactServiceImpl();
    
    
    public final static PersonContinuinigEducationService personContinuiningEducation = new PersonContinuiningEducationServiceImpl();
    public final static PersonDemographicsService personDemographicsService = new PersonDemographicsServiceImpl();
    public final static PersonEducationHistoryService personEducationHistoryService = new PersonEducationHistoryServiceImpl();
    public final static PersonEmployementHistoryService personEmployementHistoryService = new PersonEmploymentHistoryServiceImpl();
    public final static PersonHiringDecisionService personHirirngDecisionsService = new PersonHiringDecisionServiceImpl();
    
    public final static PersonIdentityService personIdentityService = new PersonIdentityServiceImpl();
    public final static PersonInterviewFeedbackService personInterviewFeedbackService = new PersonInterviewFeedbackServiceImpl();
    public final static PersonLanguageService personLanguageService = new PersonLanguageServiceImpl();
    public final static PersonPositionService personPositionService = new PersonPositionServiceImpl();
    public final static PersonRoleService personRoleService = new PersonRoleServiceImpl();
    public final static PersonService personService = new PersonServiceImpl();
}
