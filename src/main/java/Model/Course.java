package Model;

public class Course extends Category {
    private String code;

    public Course (String description, String name, String code){
        super(description, name);
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }
}
