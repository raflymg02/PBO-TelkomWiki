package telkomwiki;

import java.util.ArrayList;
//import java.util.Arrays;

public class Tagged {
    
    private ArrayList<WikiPage> pages;
    private ArrayList<Tag> tags;

    public ArrayList<WikiPage> getPages(){
        return pages;
    }
    public void setPages(ArrayList<WikiPage> pages) {
        this.pages = pages;
    }
    public ArrayList<Tag> getTags() {
        return tags;
    }
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public void addTags(Tag tag){
        this.tags.add(tag);
    }

    //public String toString() {
    //    return "Tagged{" +"pages=" + Arrays.toString(pages) +", tags=" + Arrays.toString(tags) +'}';
    //}
}
