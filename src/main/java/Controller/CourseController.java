package Controller;

import java.util.List;

import Model.Course;
import Model.Database;
import Model.WikiPage;

public class CourseController {
    private final Database database;

    public CourseController() {
        this.database = new Database();
    }

    public List<Course> getAllCourses() {
        return database.fetchAllCourses();
    }

    public List<WikiPage> getWikiPagesByCourseName(String courseName) {
        return database.fetchWikiPagesByCourseName(courseName);
    }
    
}