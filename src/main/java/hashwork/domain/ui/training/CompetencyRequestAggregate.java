package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyRequestAggregate implements Serializable {
    private String id;
    private String competencyName;
    private String status;
    private int count;

    public String getId() {
        return id;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public String getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    private CompetencyRequestAggregate(Builder builder){
        this.id = builder.id;
        this.competencyName = builder.competencyName;
        this.count = builder.count;
        this.status = builder.status;

    }

    public static class Builder{
        private String id;
        private String competencyName;
        private String status;
        private int count;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder competencyName(String value){
            this.competencyName = value;
            return this;
        }

        public Builder status(String value){
            this.status = value;
            return this;
        }

        public Builder count(int value){
            this.count = value;
            return this;
        }

        public Builder copy(CompetencyRequestAggregate value) {
            this.id = value.id;
            this.competencyName = value.competencyName;
            this.status = value.status;
            this.count = value.count;

            return this;
        }

        public CompetencyRequestAggregate build(){
            return new CompetencyRequestAggregate(this);
        }


    }




}
