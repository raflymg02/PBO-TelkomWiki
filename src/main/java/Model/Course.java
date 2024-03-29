package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course extends Category {
    @Id
    private String code;

    // Default constructor (no-argument constructor) required by Hibernate
    public Course() {
        //
    }

    public Course (String description, String name, String code){
        super(description, name);
        this.code = code;
    }

    @Override
    @Column(name = "name")
    public String getName() {
        return super.getName();
    }

    @Override
    @Column(name = "description")
    public String getDescription() {
        return super.getDescription();
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }


}