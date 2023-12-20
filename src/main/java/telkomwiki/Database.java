package telkomwiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Database implements Searchable {
    private static final String url = "jdbc:mysql://pbo.akunerio.com:3306/pbo-db-one";
    private static final String username = "pbo-user-one";
    private static final String password = "pbo-pass-one-01";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public Object searchDatabase(String dbTable) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + dbTable);
             ResultSet resultSet = preparedStatement.executeQuery()) {
    
            if ("Page".equals(dbTable)) {
                ArrayList<WikiPage> pages = new ArrayList<>();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    LocalDateTime createdAt = resultSet.getTimestamp("CreatedAt").toLocalDateTime();
                    LocalDateTime updatedAt = resultSet.getTimestamp("updatedAt").toLocalDateTime();
    
                    WikiPage page = new WikiPage(title, content, createdAt, updatedAt);
                    pages.add(page);
                }
                return pages;
            } else if ("Tag".equals(dbTable)) {
                ArrayList<Tag> tags = new ArrayList<>();
                while (resultSet.next()) {
                    String tagName = resultSet.getString("tagName");
                    String tagDesc = resultSet.getString("tagDescription");
                    Tag tag = new Tag(tagName, tagDesc);
                    tags.add(tag);
                }
                return tags;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    



    public void insertWikiPage(Connection conn, WikiPage page) {
        String insertQuery = "INSERT INTO (title, content, created_at, updated_at) VALUES (?, ?, ?, ?)";
    
        try (PreparedStatement prst = conn.prepareStatement(insertQuery)) {
            prst.setString(1, page.getTitle());
            prst.setString(2, page.getContent());
            prst.setTimestamp(3, Timestamp.valueOf(page.getCreatedAt()));
            prst.setNull(4, Types.TIMESTAMP);  // Set updated_at as NULL
    
            int affectedRows = prst.executeUpdate();
    
            // Check the affected rows if needed
            if (affectedRows > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }
        } catch (SQLException ex) {
            System.out.println("Database query error: " + ex.getMessage());
        }
    }
    
    public void searchWikiTitle(Connection conn, String title) {
        String sql = "SELECT title, content FROM wikipage WHERE title = ?";
        
        try (PreparedStatement prst = conn.prepareStatement(sql)) {
            prst.setString(1, title);
            
            try (ResultSet rs = prst.executeQuery()) {
                if (rs.next()) {
                    String resultTitle = rs.getString("title");
                    String text = rs.getString("content");
                    
                    System.out.println("Title: " + resultTitle);
                    System.out.println("Content: " + text);
                } else {
                    System.out.println("No data found for the title: " + title);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Database query error: " + ex.getMessage());
        }
    }

    
}
