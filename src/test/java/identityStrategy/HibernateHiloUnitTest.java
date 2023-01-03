package identityStrategy;

import com.example.demo.design.identityStrategy.RestaurantOrderIdentity;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@Slf4j
public class HibernateHiloUnitTest {
    private Session session;

    @BeforeEach
    public void init() {
        try {
//            configureLogger();

            ServiceRegistry serviceRegistry = configureServiceRegistry();
            SessionFactory factory = getSessionFactoryBuilder(serviceRegistry).build();
            session = factory.openSession();
        } catch (HibernateException | IOException e) {
            log.info("Failed to initiate Hibernate Session [Exception:" + e.toString() + "]");
        }
    }

//    private void configureLogger() {
//        BasicConfigurator.configure();
//        LogManager.getLogger("org.hibernate").setLevel(Level.ERROR);
//        LogManager.getLogger("org.hibernate.id.enhanced.SequenceStructure").setLevel(Level.INFO);
//        LogManager.getLogger("org.hibernate.event.internal.AbstractSaveEventListener").setLevel(Level.INFO);
//        LogManager.getLogger("org.hibernate.SQL").setLevel(Level.INFO);
//    }


    private static SessionFactoryBuilder getSessionFactoryBuilder(ServiceRegistry serviceRegistry) {
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(RestaurantOrderIdentity.class);
        Metadata metadata = metadataSources.buildMetadata();

        return metadata.getSessionFactoryBuilder();
    }

    private static ServiceRegistry configureServiceRegistry() throws IOException {
        Properties properties = getProperties();

        return new StandardServiceRegistryBuilder().applySettings(properties)
                .build();
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        URL propertiesURL = getPropertiesURL();

        try (FileInputStream inputStream = new FileInputStream(propertiesURL.getFile())) {
            properties.load(inputStream);
        }

        return properties;
    }

    private static URL getPropertiesURL() {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResource("hibernate.properties");
    }

    @Test
    public void givenIdentityStrategy() {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < 9; i++) {
            session.persist(new RestaurantOrderIdentity());
            log.info("in for loop : {}", i);
        }

        log.info(" commit! ");
        transaction.commit();
    }

    @AfterEach
    public void cleanup() {
        session.close();
    }
}
