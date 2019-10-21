import java.util.*;

/**
 * #472 Concatenated Words https://leetcode.com/problems/concatenated-words/
 */

public class ConcatenatedWords {
    private formable(String word, Set<String> dict) {

    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> prefix = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < words.length; i++) {

        }
    }
}
