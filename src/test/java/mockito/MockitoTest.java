package mockito;

import com.example.demo.object._01._01.Audience;
import com.example.demo.object._01._01.Bag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
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

  @Mock
  private Foo foo;

  @Test
  void test1(){
    when(audience.getBag()).thenReturn(new Bag(5));

    Bag bag1 = audience.getBag();

    log.info("rebase edit test");
    log.info("rebase edit test2");
    log.info("test : {}", bag1);
  }

  @Test
  void test2() {
    when(foo.bool(anyString(), anyInt(), any(Object.class))).thenReturn(true);

    assertTrue(foo.bool("A", 1, "A"));
    assertTrue(foo.bool("B", 10, new Object()));
  }

  class Foo {
    boolean bool(String str, int i, Object obj){
      return false;
    }

    int in(boolean b, List<String> strs) {
      return 0;
    }

    int bar(byte[] bytes, String[] s, int i) {
      return 0;
    }
  }

  @Test
  void programers() {
    int[] intArray = new int[]{1, 2, 3, 4};
//    Double collect = Stream.of(intArray).collect(Collectors.averagingInt(i -> (int)i));

    Arrays.stream(intArray).flatMap(i -> IntStream.of(i)).forEach(i -> System.out.println("tset :" + i));
    Arrays.stream(intArray).forEach(i -> System.out.println("tset :" + i));
    List<Integer> collect = IntStream.of(intArray).boxed().collect(Collectors.toList());
//    IntStream.of(intArray).flatMap(i -> IntStream.of(i)).collect(Collectors.averagingInt(i -> (int) i));
    log.info("IntegerListr  : {}", collect);
//    IntStream.of(intArray).
//    log.info("test : {}", collect);
//    Arrays.stream(intArray).collect(Collectors.averagingInt( i -> Integer.parseInt(i.toString())));
//    IntStream.of(intArray).map((Integer i) -> i);
//    Object test = 1;
//    int hi = (int)test;

    Stream<String> stream = Stream.of("20", "50", "75", "100", "150", "200");
    double res = stream.collect(Collectors.averagingInt(a -> Integer.parseInt(a)));
    System.out.println("Arithmetic Mean of the stream elements = "+res);

  }
}
