package ru.job4j.onetomany;

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
                .buildMetadata()
                .buildSessionFactory();
             Session session = sf.openSession()
        ) {

            session.beginTransaction();

            CarModel one = CarModel.of("model1");
            session.save(one);

            CarModel two = CarModel.of("model2");
            session.save(two);

            CarModel three = CarModel.of("model3");
            session.save(three);

            CarModel four = CarModel.of("model4");
            session.save(four);

            CarModel five = CarModel.of("model5");
            session.save(five);

            CarMark mark = CarMark.of("Main Mark");
            mark.addModel(session.load(CarModel.class, 1));
            mark.addModel(session.load(CarModel.class, 2));
            mark.addModel(session.load(CarModel.class, 3));
            mark.addModel(session.load(CarModel.class, 4));
            mark.addModel(session.load(CarModel.class, 5));

            session.save(mark);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
