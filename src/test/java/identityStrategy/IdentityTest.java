package identityStrategy;

import com.example.demo.DemoApplication;
import com.example.demo.identityStrategy.RestaurantOrderSequence;
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
            session.persist(new RestaurantOrderSequence());
            session.flush();
        }

        transaction.commit();
    }
}
