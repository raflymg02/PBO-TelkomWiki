package telkomwiki;

import java.util.ArrayList;

/**
 *
 * @author Kelompok 1
 */
public class TelkomWiki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Database db = new Database();
        ArrayList<WikiPage> pages = db.searchDatabase("Page");

        for (WikiPage page : pages) {
            System.out.println(page.toString()); // Can get each variable 
        }






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
