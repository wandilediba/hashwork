package hashwork.services.ui.training.Impl;

import hashwork.app.facade.TrainingFacade;
import hashwork.domain.ui.training.Course;
import hashwork.domain.ui.training.CourseRequest;
import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.repository.ui.training.Impl.CourseRepositoryImpl;
import hashwork.services.ui.training.CourseService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseServiceImpl implements CourseService {

    @Override
    public Course findById(String id) {
        return new CourseRepositoryImpl().findById(id);
    }

    @Override
    public Course save(Course entity) {
        return new CourseRepositoryImpl().save(entity);
    }

    @Override
    public Course update(Course entity) {
        return new CourseRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Course entity) {
        new CourseRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Course> findAll() {
        return new CourseRepositoryImpl().findAll();
    }

    @Override
    public Set<Course> getInstitutionCourses() {
        Set<Course> courses = TrainingFacade.courseService
                .findAll()
                .parallelStream()
                .filter(course -> course.getInstitutionNameId().equalsIgnoreCase("id"))
                .collect(Collectors.toSet());
        return courses;
    }

    @Override
    public Set<ScheduledCourse> getApprovedScheduledCourse() {
        Set<ScheduledCourse> scheduledCourses = TrainingFacade.scheduledCourseService
                .findAll()
                .parallelStream()
                .filter(course -> course.getStartDate().after(new Date()) & "APPROVED".equals(course.getStatus()))
                .collect(Collectors.toSet());
        return scheduledCourses;
    }

    @Override
    public Set<CourseRequest> getInstitutionCourseRequests() {
        Set<CourseRequest> courseRequests = TrainingFacade.courseRequestService
                .findAll()
                .parallelStream()
                .filter(request -> request.getTrainingInstitutionsId().contains("1"))
                .collect(Collectors.toSet());
        return courseRequests;
    }

    @Override
    public Set<ScheduledCourse> getInstitutionApprovedScheduledCourses() {
        Set<ScheduledCourse> scheduledCourses = TrainingFacade.scheduledCourseService
                .findAll()
                .parallelStream()
                .filter(course -> course.getStatus().equalsIgnoreCase("APPROVED"))
                .filter(course -> course.getCourseNameId().equalsIgnoreCase("1"))
                .collect(Collectors.toSet());

        return scheduledCourses;
    }
}
