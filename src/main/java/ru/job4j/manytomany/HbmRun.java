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

            /**
            Book first = Book.of("book1");
            Book second = Book.of("book2");
            Book third = Book.of("book3");

            Author author1 = Author.of("Author1");
            author1.getBooks().add(first);

            Author author2 = Author.of("Author2");
            author2.getBooks().add(first);
            author2.getBooks().add(second);

            Author author3 = Author.of("Author3");
            author3.getBooks().add(third);

            session.persist(author1);
            session.persist(author2);
            session.persist(author3);
             **/

            Address one = Address.of("Kazanskaya", "1");
            Address two = Address.of("Piterskaya", "10");

            Person first = Person.of("Nikolay");
            first.getAddresses().add(one);
            first.getAddresses().add(two);

            Person second = Person.of("Anatoliy");
            second.getAddresses().add(two);

            session.persist(first);
            session.persist(second);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
