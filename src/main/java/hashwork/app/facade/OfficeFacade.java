package hashwork.app.facade;

import hashwork.services.office.CompanyService;
import hashwork.services.office.DepartmentService;
import hashwork.services.office.Impl.CompanyServiceImpl;
import hashwork.services.office.Impl.DepartmentServiceImpl;
import hashwork.services.office.Impl.OfficeServiceImpl;
import hashwork.services.office.Impl.OfficeTypeServiceImpl;
import hashwork.services.office.OfficeService;
import hashwork.services.office.OfficeTypeService;

/**
 * Created by garran on 2015/09/13.
 */
public class OfficeFacade {

    public final static CompanyService companyService = new CompanyServiceImpl();
    public final static DepartmentService departmentService = new DepartmentServiceImpl();
    public final static OfficeService officeService = new OfficeServiceImpl();
    public final static OfficeTypeService officeTypeService = new OfficeTypeServiceImpl();
}
