package test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class MixElementTest {


  Set<String> setString = new HashSet<>();

  @Test
  void test() {
    int[] tempArray = {1,3,5, 7};

    String collect = Arrays.stream(tempArray)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining());

    recursive("", collect);

    log.info("testsetst : {}", setString);


  }

  /**
   *
   * null, abcd
   * a, bcd
   * ab,cd
   * abc,d
   * abcd, null
   * b,acd
   * ba,cd
   * bac, d
   * bacd, null
   * c, abd
   * ca, bd
   * cab, d
   * cabd, null
   * d, abc
   * da, bc
   * dab, c
   * babc, null
   * ab, cd
   * abc, null
   * abcd, null
   * abd, null
   * abdc, null
   *
   */

  private void recursive(String comp, String another ){
    for(int i = 0; i < another.length(); i++){
      log.info("comp : {}", comp);
      setString.add(comp+another.charAt(i));
      recursive(comp+another.charAt(i), another.substring(0,i)+another.substring(i+1));
    }
  }
}
