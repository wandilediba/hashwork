package hashwork.client.content.system.positions.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.JobFacade;
import hashwork.app.facade.OfficeFacade;
import hashwork.app.facade.PositionFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.Department;
import hashwork.domain.office.Office;
import hashwork.domain.payroll.ui.job.Job;
import hashwork.domain.ui.position.Position;
import hashwork.domain.ui.position.PositionType;

import java.util.Date;
import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionTable extends Table {

    private final MainLayout main;

    public PositionTable(MainLayout main) {
        this.main = main;
        setSizeFull();


        addContainerProperty("Position Title", String.class, null);
        addContainerProperty("Position Code", String.class, null);
        addContainerProperty("Position Type", String.class, null);
        addContainerProperty("Job", String.class, null);
        addContainerProperty("Supervisor", String.class, null);
        addContainerProperty("Office", String.class, null);
        addContainerProperty("Department", String.class, null);
        addContainerProperty("Date Created", Date.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Comments", String.class, null);

        // Add Data Columns
        Set<Position> positions = PositionFacade.positionService.findAll();
        for (Position position : positions) {
            addItem(new Object[]{position.getPositionTitle(),
                    position.getPositionCode(),
                    positionType(position.getPositionTypeId()),
                    job(position.getJobId()),
                    supervisor(position.getSupervisorId()),
                    office(position.getOfficeId()),
                    department(position.getDepartmentId()),
                    position.getPostionEntryDate(),
                    position.getDescription(),
                    position.getPositionComments()}, position.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    private String positionType(String positionTypeId) {
        PositionType positionType = PositionFacade.positionTypeService.findById(positionTypeId);
        if (positionType != null) {
            return positionType.getName();
        }
        return null;
    }

    private String job(String jobId) {
        Job job = JobFacade.jobService.findById(jobId);
        if (job != null) {
            return job.getTitle();
        }
        return null;
    }

    private String supervisor(String supervisorId) {
        Position supervisor = PositionFacade.positionService.findById(supervisorId);
        if (supervisor != null) {
            return supervisor.getPositionTitle();
        }
        return null;
    }

    private String office(String officeId) {
        Office office = OfficeFacade.officeService.findById(officeId);
        if (office != null) {
            return office.getName();
        }
        return null;
    }

    private Object department(String departmentId) {
        Department department = OfficeFacade.departmentService.findById(departmentId);
        if (department != null) {
            return department.getName();
        }
        return null;
    }
}