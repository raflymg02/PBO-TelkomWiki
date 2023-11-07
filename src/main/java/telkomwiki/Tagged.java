package telkomwiki;

import java.util.Arrays;

public class Tagged {
    private WikiPage[] pages;
    private Tag[] tags;
    public Tagged(WikiPage[] pages, Tag[] tags) {
        this.pages = pages;
        this.tags = tags;
    }
    public WikiPage[] getPages(){
        return pages;
    }
    public void setPages(WikiPage[] pages) {
        this.pages = pages;
    }
    public Tag[] getTags() {
        return tags;
    }
    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
    public String toString() {
        return "Tagged{" +"pages=" + Arrays.toString(pages) +", tags=" + Arrays.toString(tags) +'}';
    }
}
