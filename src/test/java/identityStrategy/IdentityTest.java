package identityStrategy;

import ch.qos.logback.classic.BasicConfigurator;
import com.example.demo.DemoApplication;
import com.example.demo.identityStrategy.RestaurantOrder;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = DemoApplication.class)
public class IdentityTest {

    private Session session;


    @Test
    void hiloTest(){

    }
    public void persist() {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < 9; i++) {
            session.persist(new RestaurantOrder());
            session.flush();
        }

        transaction.commit();
    }
}
