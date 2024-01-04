package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Course;
import Model.Database;
import Model.Searchable;
import Model.WikiPage;

public class CourseController implements Searchable {
    private final Database database;

    public CourseController() {
        this.database = new Database();
    }

    public List<Object> getAllData() {
        List<Course> Courses = database.fetchAllCourses();
        List<Object> resultList = new ArrayList<>();

        for (Course course : Courses) {
            resultList.add((Object) course); // Explicitly cast WikiPage to Object
        }
        return resultList;
    }


    public List<WikiPage> getWikiPagesByCourseName(String courseName) {
        return database.fetchWikiPagesByCourseName(courseName);
    }
    
}