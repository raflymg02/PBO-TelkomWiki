package Model;

import java.time.LocalDateTime;

public class ModelTest {
    public static void main(String[] args) {
        Category C  = new Category("description", "name");
        Course E = new Course("description", "name", "code");
        Semester S = new Semester("desription", "name");
        Tag T = new Tag("name", "desription");
        WikiPage W = new WikiPage( "title", "content", LocalDateTime.now(), LocalDateTime.now());

    }
    
}
