package telkomwiki;
import java.util.ArrayList;

public class Category extends Organization{
    private String description;
    private Category partof;
    private ArrayList<WikiPage> pages;

    public Category(String name){
        super(name);
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

    public ArrayList<WikiPage> getPages() {
        return this.pages;
    }

    public void addPage(WikiPage page){
        this.pages.add(page);
    }
}
// ] Pages ;

// public String getDescription() {
// return description;
// }

// public Category getPartof() {
// return partof;
// }

// public Category[] getSubcategories() {
// return subcategories;
// }

// public WikiPage[] getPages() {
// return Pages;
// }

// public void setDescription(String description) {
// this.description = description;
// }

// public void setPartof(Category partof) {
// this.partof = partof;
// }

// public void setSubcategories(Category[] subcategories) {
// this.subcategories = subcategories;
// }

// public void setPages(WikiPage[] Pages) {
// this.Pages = Pages;
// }
// }
