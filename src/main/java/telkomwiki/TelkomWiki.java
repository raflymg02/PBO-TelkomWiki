package telkomwiki;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kelompok 1
 */
public class TelkomWiki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        /* Format */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(formatter);

        WikiPage page1 = new WikiPage("Linked List", "Lorem Ipsum", LocalDateTime.parse(formattedDateTime, formatter));






        /* IGNORE THIS: Connect to Local Database */
        // Database db = new Database("jdbc:postgresql://localhost:5432/pbo", "demo", "1234");


        //  try {
        //     Connection conn = db.connect();

        //     if (conn != null) {
        //         System.out.println("Connected to the database.");

        //         db.insertWikiPage(conn, page1);
        //         db.searchWikiTitle(conn, "Linked List");
    
        //     } else {
        //         System.out.println("Failed to connect to the database.");
        //     }
        //     conn.close();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        //     System.out.println("Database connection error: " + e.getMessage());
        // } 

        

    }

}
