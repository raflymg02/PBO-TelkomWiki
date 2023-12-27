package Controller;

import java.util.List;

import Model.Database;
import Model.WikiPage;

public class WikiPageController {
    private final Database database;

    public WikiPageController() {
        this.database = new Database(); // Create an instance of the Database class
    }

    // Method to retrieve all WikiPages from the database using Hibernate
    public List<WikiPage> getAllWikiPages() {
        return database.fetchWikiPages();
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
