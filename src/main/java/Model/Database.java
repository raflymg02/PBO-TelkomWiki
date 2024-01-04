package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Database {
    private final SessionFactory sessionFactory;
    private final String jdbcURL = "jdbc:mysql://pbo.akunerio.com:3306/pbo-db-one";
    private final String username = "pbo-user-one";
    private final String password = "pbo-pass-one-01";

    public Database() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(WikiPage.class)
                .addAnnotatedClass(Tag.class)
                // Add other annotated classes as needed
                .buildSessionFactory();
    }

    private Connection getJDBCConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    /* ============================================ WIKIPAGE CLASS ============================================ */


    public List<WikiPage> fetchWikiPages() {
        try (Session session = sessionFactory.openSession()) {
            Query<WikiPage> query = session.createQuery("FROM WikiPage", WikiPage.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(); 
    }

    public void saveOrUpdateWikiPage(WikiPage wikiPage) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(wikiPage);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public WikiPage fetchWikiPageByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            Query<WikiPage> query = session.createQuery("FROM WikiPage WHERE title = :title", WikiPage.class);
            query.setParameter("title", title);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    /* ============================================ COURSE CLASS ============================================ */

    public List<Course> fetchAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course"; 
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            // Process the retrieved data and create Course objects
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
    
                Course course = new Course(description, name, code);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return courses;
    }

    public List<WikiPage> fetchWikiPagesByCourseName(String courseName) {
        List<WikiPage> wikiPages = new ArrayList<>();

        try (Connection connection = getJDBCConnection()) {
            // Prepare a PreparedStatement to fetch Course based on name
            String selectCourseQuery = "SELECT * FROM Course WHERE name = ?";
            PreparedStatement courseStatement = connection.prepareStatement(selectCourseQuery);
            courseStatement.setString(1, courseName);

            ResultSet courseResult = courseStatement.executeQuery();

            if (courseResult.next()) {
                String courseCode = courseResult.getString("code");

                // Prepare a PreparedStatement to fetch WikiPages based on courseId
                String selectWikiPagesQuery = "SELECT * FROM WikiPage WHERE courseCode = ?";
                PreparedStatement wikiStatement = connection.prepareStatement(selectWikiPagesQuery);
                wikiStatement.setString(1, courseCode);

                ResultSet wikiResult = wikiStatement.executeQuery();

                while (wikiResult.next()) {
                    WikiPage wikiPage = new WikiPage();
                    wikiPage.setTitle(wikiResult.getString("title"));
                    wikiPage.setContent(wikiResult.getString("content"));

                    wikiPages.add(wikiPage);
                }

                wikiStatement.close();
            }

            courseStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wikiPages;
    }

    public List<Semester> fetchAllSemesters() {
        List<Semester> semesters = new ArrayList<>();
        String sql = "SELECT DISTINCT Semester.semesterNo, Semester.semesterDescription " +
                     "FROM Semester " +
                     "INNER JOIN Course ON Semester.id = Course.semesterId";
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String semesterName = resultSet.getString("semesterNo");
                String semesterDescription = resultSet.getString("semesterDescription");
                
                Semester semester = new Semester(semesterDescription, semesterName);
                semesters.add(semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return semesters;
    }
    

    public List<Course> fetchCoursesBySemester(String semester) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course WHERE semesterId = ?";
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
            preparedStatement.setString(1, semester);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
    
                Course course = new Course(description, name, code);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return courses;
    }
    

    /* ============================================ TAG CLASS ============================================ */

    public List<Tag> fetchAllTags() {
        List<Tag> tags = new ArrayList<>();
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String query = "SELECT * FROM Tag";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String tagName = resultSet.getString("tagName");
                String tagDescription = resultSet.getString("tagDescription");
    
                Tag tag = new Tag(tagName, tagDescription);
                tags.add(tag);
            }
    
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    
        return tags;
    }
    
    public List<Tag> fetchTagsByWikiPage(String wikiPageTitle) {
        List<Tag> tags = new ArrayList<>();
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String query = "SELECT Tag.* FROM Tag " +
                    "INNER JOIN Tagged ON Tag.tagID = Tagged.tagId " +
                    "INNER JOIN WikiPage ON WikiPage.id = Tagged.wikiId " +
                    "WHERE WikiPage.title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, wikiPageTitle);
    
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String tagName = resultSet.getString("tagName");
                String tagDescription = resultSet.getString("tagDescription");
    
                Tag tag = new Tag(tagName, tagDescription);
                tags.add(tag);
            }
    
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tags;
    }

    public List<WikiPage> fetchWikiPageByTag(String tagName) {
        List<WikiPage> wikiPages = new ArrayList<>();
    
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String query =
                "SELECT WikiPage.* FROM WikiPage " +
                "INNER JOIN Tagged ON WikiPage.id = Tagged.wikiId " +
                "INNER JOIN Tag ON Tag.tagId = Tagged.tagID " +
                "WHERE Tag.tagName = ?";
    
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tagName);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                // Retrieve necessary data for WikiPage objects

                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
                LocalDateTime createdAt = createdAtTimestamp.toLocalDateTime();

                Timestamp updatedAtTimestamp = resultSet.getTimestamp("updatedAt");
                LocalDateTime updatedAt = updatedAtTimestamp.toLocalDateTime();
                
                WikiPage wikiPage = new WikiPage(title, content, createdAt, updatedAt);
    
                wikiPages.add(wikiPage);
            }
    
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return wikiPages;
    }
    
    
    
    
    
    
}