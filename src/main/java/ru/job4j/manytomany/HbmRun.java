package ru.job4j.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
             Session session = sf.openSession()
        ) {
            session.beginTransaction();

            Book first = Book.of("book1");
            Book second = Book.of("book2");
            Book third = Book.of("book3");

            Author author1 = Author.of("Author1");
            author1.getBooks().add(first);
            session.persist(author1);

            Author author2 = Author.of("Author2");
            author2.getBooks().add(second);
            session.persist(author2);

            author2.getBooks().add(third);
            session.persist(author2);

            Author author3 = Author.of("Author3");
            author3.getBooks().add(third);
            session.persist(author3);

            Author author = session.get(Author.class, 1);
            session.remove(author);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
