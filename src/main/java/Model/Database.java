package Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Database {
    private final SessionFactory sessionFactory;

    public Database() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(WikiPage.class)
                .addAnnotatedClass(Tag.class)
                // Add other annotated classes as needed
                .buildSessionFactory();
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

    // Other methods for specific Hibernate operations as needed
}
