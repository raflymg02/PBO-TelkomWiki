package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Database;
import Model.Searchable;
import Model.WikiPage;

public class WikiPageController implements Searchable {
    private final Database database;

    public WikiPageController() {
        this.database = new Database(); 
    }

    // Polymorphism - Explicit Casting
    // Method to retrieve all WikiPages 
    public List<Object> getAllData() {
        List<WikiPage> wikiPages = database.fetchWikiPages();
        List<Object> resultList = new ArrayList<>();

        for (WikiPage wikiPage : wikiPages) {
            resultList.add((Object) wikiPage); // Explicitly cast WikiPage to Object
        }

        return resultList;
    }

    // Method to search for a WikiPage by its title 
    public WikiPage searchWikiPageByTitle(String title) {
        return database.fetchWikiPageByTitle(title);
    }


}
