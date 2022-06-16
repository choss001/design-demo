package genegic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class wildCardTest {

  @Test
  void test1() {
    List<Integer> li = Arrays.asList(1, 2, 3);
//    printListObject(li);
    printListWildCard(li);

    List someList = new ArrayList<>();
    boolean instanceTest1 = someList instanceof List<?>;

//    List anotherList = new ArrayList<>();
//    boolean instanceTest2 = anotherList instanceof List<? extends Object>;

    TypeReference<Map<String, Integer>> token = new TypeReference<Map<String, Integer>>() {};
    log.info("test : {}", token);
  }

  private static void printListObject(List<Object> list){
    for (Object element : list) {
      System.out.println(element + " ");
    }
  }

  public abstract class TypeReference<T> {

    private final Type type;

    public TypeReference() {
      Type superclass = getClass().getGenericSuperclass();
      type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }

    public Type getType() {
      return type;
    }
  }

  private static void printListWildCard(List<?> list) {
    for (Object element : list) {
      System.out.println(element + " ");
    }
  }
}
