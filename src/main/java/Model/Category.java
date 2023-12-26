package Model;
import java.util.ArrayList;

public class Category extends Organization{
    private String description;
    private Category partof;
    private ArrayList<WikiPage> pageList;

    public Category (String description, String name){
        super(name);
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
    public Category getPartof() {
        return this.partof;
    }

    public void setPartof(Category partof){
        this.partof = partof;
    }

    public ArrayList<WikiPage> getPageList() {
        return this.pageList;
    }

    public void addPage(WikiPage page){
        this.pageList.add(page);
    }

    public void removePage(WikiPage page){
        this.pageList.remove(page);
    }
}
