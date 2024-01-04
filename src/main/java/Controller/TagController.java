package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Database;
import Model.Searchable;
import Model.Tag;
import Model.WikiPage;

public class TagController implements Searchable {
    private final Database database;

    public TagController() {
        this.database = new Database();
    }

    public List<Object> getAllData() {
        List<Tag> tags = database.fetchAllTags();
        List<Object> resultList = new ArrayList<>();

        for (Tag tag : tags) {
            resultList.add((Object) tag); // Explicitly cast WikiPage to Object
        }

        return resultList;
    }

    public List<Tag> fetchTagsByWikiPageTitle(String wikiPageTitle) {
        return database.fetchTagsByWikiPage(wikiPageTitle);
    }

    public List<WikiPage> fetchWikiPageByTag(String tagName) {
        return database.fetchWikiPageByTag(tagName);
    }
}
