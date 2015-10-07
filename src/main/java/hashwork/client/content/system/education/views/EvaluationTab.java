package hashwork.client.content.system.education.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.education.EducationMenu;
import hashwork.client.content.system.education.forms.EvaluationForm;
import hashwork.client.content.system.education.model.EvaluationModel;
import hashwork.client.content.system.education.table.EvaluationTable;
import hashwork.domain.ui.education.Evaluation;
import hashwork.factories.ui.education.EvaluationFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zamzam on 2015/10/07.
 */
public class EvaluationTab extends VerticalLayout implements Button.ClickListener,
        Property.ValueChangeListener{
    private final MainLayout main;
    private final EvaluationForm form;
    private final EvaluationTable table;
    
    public EvaluationTab(MainLayout app){
        main = app;
        form = new EvaluationForm();
        table = new EvaluationTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
        
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final Evaluation evaluation = EducationFacade.evaluationService.findById(table.getValue().toString());
            final EvaluationModel model = getModel(evaluation);
            form.binder.setItemDataSource(new BeanItem<>(model));
            setReadFormProperties();
        }
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((Button.ClickListener) this);
        form.edit.addClickListener((Button.ClickListener) this);
        form.cancel.addClickListener((Button.ClickListener) this);
        form.update.addClickListener((Button.ClickListener) this);
        form.delete.addClickListener((Button.ClickListener) this);
        //Register Table Listeners
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            EducationFacade.evaluationService.save(getNewEntity(binder));
//            EvaluationFacade.EvaluationService.save(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            //EvaluationFacade.EvaluationService.update(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        Evaluation evaluation = EducationFacade.evaluationService.findById(table.getValue().toString());
        if(false){
            Notification.show("CANNOT DELETE", "Object has related Items. Delete Related Items First", Notification.Type.ERROR_MESSAGE);
        }else{
            EducationFacade.evaluationService.delete(evaluation);
            getHome();
        }

    }
    private void getHome() {
        main.content.setSecondComponent(new EducationMenu(main, "EVALUATION"));
    }
    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviour
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private Evaluation getNewEntity(FieldGroup binder) {
        final EvaluationModel model = ((BeanItem<EvaluationModel>) binder.getItemDataSource()).getBean();
        final Evaluation evaluation = EvaluationFactory.getEvaluation(
                model.getName()
        );
        return evaluation;
    }

    private Evaluation getUpdateEntity(FieldGroup binder) {
        final EvaluationModel model = ((BeanItem<EvaluationModel>) binder.getItemDataSource()).getBean();
        final Evaluation Evaluation = EducationFacade.evaluationService.findById(table.getValue().toString());
        final Evaluation updatedEvaluation = new Evaluation
                .Builder().copy(Evaluation).name(model.getName()).build();
        return updatedEvaluation;
    }

    private EvaluationModel getModel(Evaluation evaluation) {
        final EvaluationModel model = new EvaluationModel();
        model.setName(evaluation.getName());
        return model;
    }
}
