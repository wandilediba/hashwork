package hashwork.domain.hr;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

public class Employee implements Serializable{

    private Long id; 
    private String employeeNumber;
    private String name;
    private String surname;
    private String identificationNumber;
    private Date hireDate;
    private String employeeType;
    private Contact contact;

    private Address address;
//    @OneToOne (cascade=CascadeType.ALL)
//    @JoinColumn(name = "job_id")
//    private Job job;
    
    private Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

//    public Job getJob() {
//        return job;
//    }
    
    public Employee(Employee.Builder builder) {
        id=builder.id;
        employeeNumber=builder.employeeNumber;
        name=builder.name;
        surname=builder.surname;
        identificationNumber=builder.identificationNumber;
        hireDate=builder.hireDate;
        employeeType=builder.employeeType;
        contact=builder.contact;
        address=builder.address;
//        job=builder.job;
    }
    
    public static class Builder{
        private Long id; 
        private String employeeNumber;
        private String name;
        private String surname;
        private String identificationNumber;
        private Date hireDate;
        private String employeeType;
        private Contact contact;
        private Address address;
//        private Job job;
        
        public Builder(String employeeNumber) {
            this.employeeNumber = employeeNumber;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder name(String value){
            this.name=value;
            return this;
        }
        
        public Builder surname(String value){
            this.surname=value;
            return this;
        }
        
        public Builder identificationNumber(String value){
            this.identificationNumber=value;
            return this;
        }
        
        public Builder hireDate(Date value){
            this.hireDate=value;
            return this;
        }
        
        public Builder employeeType(String value){
            this.employeeType=value;
            return this;
        }
       
        public Builder contact(Contact value){
            this.contact=value;
            return this;
        }
        
            public Builder address(Address value){
            this.address=value;
            return this;
        }
        
//        public Builder job(Job value){
//            this.job=value;
//            return this;
//        }
        
        public Builder copy(Employee value){
            this.id=value.id;
            this.employeeNumber=value.employeeNumber;
            this.name=value.name;
            this.surname=value.surname;
            this.identificationNumber=value.identificationNumber;
            this.hireDate=value.hireDate;
            this.employeeType=value.employeeType;
            this.contact=value.contact;
            this.address=value.address;
//            this.job=value.job;
            return this;
        }
        
        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
