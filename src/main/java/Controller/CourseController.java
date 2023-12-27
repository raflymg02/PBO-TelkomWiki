package Controller;

import java.util.List;

import Model.Course;
import Model.Database;

public class CourseController {
    private final Database database;

    public CourseController() {
        this.database = new Database();
    }

    public List<Course> getAllCourses() {
        return database.fetchAllCourses(); // Corrected method call to fetch courses
    }
}