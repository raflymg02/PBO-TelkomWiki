package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Course;
import Model.Database;
import Model.Searchable;
import Model.Semester;
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
            resultList.add((Object) course); 
        }
        return resultList;
    }


    public List<WikiPage> getWikiPagesByCourseName(String courseName) {
        return database.fetchWikiPagesByCourseName(courseName);
    }

    public List<Course> getCoursesBySemester(String semester) {
        return database.fetchCoursesBySemester(semester);
    }

    public List<Object> fetchAllSemesters() {
        List<Semester> semesters = database.fetchAllSemesters();
        List<Object> resultList = new ArrayList<>();

        for (Semester semester : semesters) {
            resultList.add((Object) semester); 
        }
        return resultList;
    }
    
    
}