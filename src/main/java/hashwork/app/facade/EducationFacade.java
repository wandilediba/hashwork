/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.app.facade;

import hashwork.services.ui.education.CompetencyService;
import hashwork.services.ui.education.CompetencyTypeService;
import hashwork.services.ui.education.DegreeService;
import hashwork.services.ui.education.EducationTypeService;
import hashwork.services.ui.education.EvaluationService;
import hashwork.services.ui.education.Impl.CompetencyServiceImpl;
import hashwork.services.ui.education.Impl.CompetencyTypeServiceImpl;
import hashwork.services.ui.education.Impl.DegreeServiceImpl;
import hashwork.services.ui.education.Impl.EducationTypeServiceImpl;
import hashwork.services.ui.education.Impl.EvaluationServiceImpl;
import hashwork.services.ui.location.Impl.AddressTypeServiceImpl;
import hashwork.services.ui.location.Impl.ContactListServiceImpl;
import hashwork.services.ui.location.Impl.LocationServiceImpl;
import hashwork.services.ui.location.Impl.RegistrationBodyServiceImpl;

/**
 *
 * @author BKLAAS1
 */
public class EducationFacade {
    
     public final static CompetencyService contactListService = new CompetencyServiceImpl();
    public final static CompetencyTypeService registrationBodyService = new CompetencyTypeServiceImpl();
    public final static DegreeService locationTypeService = new DegreeServiceImpl();
    public final static EducationTypeService locationService = new EducationTypeServiceImpl();
    public final static EvaluationService addressTypeService = new EvaluationServiceImpl();
    
}
