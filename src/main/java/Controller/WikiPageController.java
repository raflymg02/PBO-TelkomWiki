package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Model.Database;
import Model.WikiPage;

public class WikiPageController {
    private final Database database;

    public WikiPageController() {
        this.database = new Database(); // Create an instance of the Database class
    }

    // Method to retrieve all WikiPages from the database
    public ArrayList<WikiPage> getAllWikiPages() {
        ArrayList<WikiPage> pages = new ArrayList<>();
        ArrayList<WikiPage> wikiPages = (ArrayList<WikiPage>) database.searchDatabase("Page");
        if (wikiPages != null) {
            pages.addAll(wikiPages);
        }
        return pages;
    }

    // Method to insert a new WikiPage into the database
    public void createWikiPage(WikiPage wikiPage) {
        try (Connection conn = database.connect()) {
            database.insertWikiPage(conn, wikiPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to search for a WikiPage by its title
    public WikiPage searchWikiPageByTitle(String title) {
        try (Connection conn = database.connect();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT title, content, createdAt, updatedAT FROM Page WHERE title = ?")) {
            preparedStatement.setString(1, title);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String resultTitle = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
                    LocalDateTime createdAt = createdAtTimestamp.toLocalDateTime();
                    Timestamp updatedAtTimestamp = resultSet.getTimestamp("updatedAt");
                    LocalDateTime updatedAt = updatedAtTimestamp.toLocalDateTime();

                    // Create a WikiPage object with retrieved data
                    return new WikiPage(resultTitle, content, createdAt, updatedAt);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; 
    }
}