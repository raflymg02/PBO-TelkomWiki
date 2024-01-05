package Model;

import java.time.LocalDateTime;

public class ModelTest {
    public static void main(String[] args) {
        Category cat  = new Category("catdescription", "catname");
        Course course = new Course("coursedescription", "coursename", "coursecode");
        
        Tag tag = new Tag("tagname", "tagdesription");
        WikiPage wiki1 = new WikiPage( "w1title", "w1content", LocalDateTime.now(), LocalDateTime.now());
        WikiPage wiki2 = new WikiPage( "w2title", "w2content", LocalDateTime.now(), LocalDateTime.now());   
        
        System.out.println("SAMPLE MODEL TEST");
        System.out.println(cat.getName());
        System.out.println(cat.getDescription());
        //System.out.println(cat.getPartof().getName());
        cat.setPartof(cat);
        System.out.println(cat.getPartof().getName());

        System.out.println();
        System.out.println(course.getName());
        course.addPage(wiki1);
        course.addPage(wiki2);

        for(int i = 0; i < 2; i++){
            System.out.println(i+i);
            System.out.println(course.getPageList().get(i).getTitle());
        }

        System.out.println();
        course.removePage(wiki1);
        System.out.println(course.getPageList().get(0).getTitle());

        System.out.println(tag.getDescription());
    }
    
    
}
