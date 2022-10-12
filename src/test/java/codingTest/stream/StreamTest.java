package codingTest.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

@Slf4j
public class StreamTest {

  @Test
  void test1() {
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k = 2;
    List<String> idList = Arrays.stream(id_list).distinct().collect(Collectors.toList());
//    log.info("test : {}", collect);
    List<String> reportStream = Arrays.stream(report).distinct().collect(Collectors.toList());

    int[] test = {5, 6, 3};
    int[] ints = Arrays.stream(test).sorted().toArray();
    List<Integer> collect = Arrays.stream(test).sorted().boxed().collect(Collectors.toList());
    log.info("test : {}", collect);


  }

  @Test
  void test2() {
    String rsp = "205";

    String collect = Arrays.stream(rsp.split(""))
        .map(i -> {
          if (i.equals("2"))
            return "0";
          else if (i.equals("0"))
            return "5";
          else
            return "2";
        }).collect(Collectors.joining());
    List<Integer> integers = Arrays.asList(0, 1);
    boolean contains = integers.contains(0);
    String[] test  = {"a", "b"};
    List<String> strings = new ArrayList<>(Arrays.asList(test));
    Collections.reverse(strings);

    log.info("test : {}", strings);
  }


}
