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
        Object Page = db.searchDatabase("Page");

        if (Page instanceof ArrayList<?>) {
            ArrayList<?> pageList = (ArrayList<?>) Page;
            for (Object obj : pageList) {
                System.out.println(obj.toString()); // Can get each attribute with getter
            }
        } else {
            System.out.println("PageObject is not an ArrayList.");
        }

        Object Tag = db.searchDatabase("Tag");

        if (Tag instanceof ArrayList<?>) {
            ArrayList<?> tagList = (ArrayList<?>) Tag;
            for (Object obj : tagList) {
                System.out.println(obj.toString()); //Can get each attribute with getter
            }
        } else {
            System.out.println("TagObject is not an ArrayList.");
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
