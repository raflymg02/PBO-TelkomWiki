package telkomwiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

public class Database implements Searchable {
    private String url;
    private String username;
    private String password;

    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void insertWikiPage(Connection conn, WikiPage page) {
        String insertQuery = "INSERT INTO wikipage (title, content, created_at, updated_at) VALUES (?, ?, ?, ?)";
    
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
