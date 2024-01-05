package Model;

import java.util.ArrayList;
//import java.util.Arrays;

public class Tagged {
    
    private ArrayList<WikiPage> pageList;
    private ArrayList<Tag> tagList;

    public Tagged() {
        //
        pageList = new ArrayList<WikiPage>();
        tagList = new ArrayList<Tag>();
    }

    public ArrayList<WikiPage> getPageList(){
        return pageList;
    }
    
    public void setPageList(ArrayList<WikiPage> pages) {
        this.pageList = pages;
    }

    public ArrayList<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<Tag> tags) {
        this.tagList = tags;
    }

    public void addTag(Tag tag){
        this.tagList.add(tag);
    }

    public void removeTag(Tag tag){
        this.tagList.remove(tag);
    }
    //public String toString() {
    //    return "Tagged{" +"pages=" + Arrays.toString(pages) +", tags=" + Arrays.toString(tags) +'}';
    //}
}
