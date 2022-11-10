package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class _205 {
  private String M = "FFFMMM";
  private String N = "MMMFFF";


  @Test
  void test1() {
    log.info("result : {}", hugs(M, N));
  }

  private int hugs(String members, String fans) {
    int N = members.length();
    int M = fans.length();
    List<Integer> A = new ArrayList<>();
    List<Integer> B = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      if(members.charAt(i) == 'M')
        A.set(i, 1);
    }

    for (int i = 0; i < N; i++) {
      if(fans.charAt(i) == 'M')
        B.set(M-i-1, 1);
    }
    List<Integer> C = karatsuba(A, B);

    int allHugs = 0;
    for(int i = N-1; i < M; i++)
      if(C.get(i) == 0)
        ++allHugs;

    return allHugs;
  }

  private List<Integer> karatsuba(List<Integer> a, List<Integer> b) {
    return null;
  }

}
