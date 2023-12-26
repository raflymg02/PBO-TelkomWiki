package Model;

import java.sql.Connection;

public interface Searchable {

    void insertWikiPage(Connection conn, WikiPage title);
    void searchWikiTitle(Connection conn, String title);

    
}
