package Model;

import java.util.ArrayList;

public class Semester extends Category{
    private ArrayList<Course> courseList;

    public Semester (){
        //
    }

    public Semester (String description, String name){
        super(description, name);
        courseList = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourseList(){
        return courseList;
    }
    public void addCourse(Course course){
        this.courseList.add(course);
    }

    public void removeCourse(Course course){
        this.courseList.remove(course);
    }
}
