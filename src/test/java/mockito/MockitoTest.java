package mockito;

import com.example.demo.object._01._01.Audience;
import com.example.demo.object._01._01.Bag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class MockitoTest {

  /**
   * 모키토 테스트
   */

  @Mock
  private Bag bag;

  @Mock
  private Audience audience;

  @Test
  void test1(){
    when(audience.getBag()).thenReturn(new Bag(5));

    Bag bag1 = audience.getBag();

    log.info("test : {}", bag1);
  }
}
