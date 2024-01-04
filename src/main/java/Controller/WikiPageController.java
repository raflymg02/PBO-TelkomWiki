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
    // Method to retrieve all WikiPages from the database using Hibernate
    public List<Object> getAllData() {
        List<WikiPage> wikiPages = database.fetchWikiPages();
        List<Object> resultList = new ArrayList<>();

        for (WikiPage wikiPage : wikiPages) {
            resultList.add((Object) wikiPage); // Explicitly cast WikiPage to Object
        }

        return resultList;
    }

    // Method to insert a new WikiPage into the database using Hibernate
    public void createWikiPage(WikiPage wikiPage) {
        database.saveOrUpdateWikiPage(wikiPage);
    }

    // Method to search for a WikiPage by its title using Hibernate
    public WikiPage searchWikiPageByTitle(String title) {
        return database.fetchWikiPageByTitle(title);
    }


}
