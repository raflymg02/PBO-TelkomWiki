package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    // Method to fetch all WikiPages using Hibernate
    public List<WikiPage> fetchWikiPages() {
        try (Session session = sessionFactory.openSession()) {
            Query<WikiPage> query = session.createQuery("FROM WikiPage", WikiPage.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(); // Return an empty list using Java 9+ List.of()
    }

    // Method to save or update a WikiPage using Hibernate
    public void saveOrUpdateWikiPage(WikiPage wikiPage) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(wikiPage);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to fetch a WikiPage by its title using Hibernate
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

    public List<Course> fetchAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course"; // Define the SQL query
    
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
                    // Create WikiPage objects based on retrieved data
                    WikiPage wikiPage = new WikiPage();
                    wikiPage.setTitle(wikiResult.getString("title"));
                    wikiPage.setContent(wikiResult.getString("content"));
                    // Set other attributes as needed

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
    
    
    
}
