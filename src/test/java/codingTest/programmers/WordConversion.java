package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WordConversion {
    private static String TARGET = null;
    private static String[] WORDS;
    private static int answer = Integer.MAX_VALUE;

    @Test
    void test(){
        String[] words =new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";
        log.info("result : {}",solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        TARGET = target;
        WORDS = words;

        HashMap<String, Integer> initialHm = setHashMap(words);


        if(!isCheckLastAnswer(target, words))
            return 0;

        recursive(initialHm, begin);
        return answer;


    }

    private boolean isCheckLastAnswer(String target, String[] words){
        for(int i =0; i < words.length; i++){
            if(words[i].equals(target))
                return true;
        }
        return false;
    }

    private void recursive(HashMap<String, Integer> trace, String words){
        for(int i = 0; i < WORDS.length; i++){
            if(trace.get(WORDS[i]) == 0 &&
                    checkOneDifferent(words, WORDS[i])){
                HashMap<String, Integer> hashMapNew = copyHashMap(trace);
                hashMapNew.put(WORDS[i], 1);
                if(TARGET.equals(WORDS[i])){
                    checkAnswerCount(hashMapNew);
                    continue;
                }
                recursive(hashMapNew, WORDS[i]);
            }
        }
    }

    private HashMap<String, Integer> setHashMap(String[] words){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < words.length; i ++){
            hashMap.put(words[i], 0);
        }
        return hashMap;
    }

    private void checkAnswerCount(HashMap<String, Integer> hashMap){
        int answer = 0;
        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                answer++;
            }
        }
        this.answer = Math.min(answer, this.answer);

    }

    private boolean checkOneDifferent(String oldWord, String newWord){
        char[] oldArray = oldWord.toCharArray();
        char[] newArray = newWord.toCharArray();
        int dif = 0;
        for(int i =0; i < oldArray.length; i++){
            if(oldArray[i] != newArray[i]){
                dif++;
            }
        }
        return dif == 1 ? true : false;
    }

    private HashMap<String, Integer> copyHashMap(HashMap<String, Integer> hashMapOlder){
        HashMap<String, Integer> hashMapNew = new HashMap<>();
        for(Map.Entry<String, Integer> entry : hashMapOlder.entrySet()) {
            hashMapNew.put(entry.getKey(), entry.getValue());
        }
        return hashMapNew;
    }

    /** 한번 쓴 단어는 다시 사용하지 않는다
     *
     */
}
