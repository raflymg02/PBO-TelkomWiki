package telkomwiki;

public class Tag extends Organization{
    private String description;
    public Tag(String name, String description){
        super(name);
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String toString() {
        return "Tag{" +"name='" + getName() + '\'' +", description='" + description + '\'' +'}';
    }
}