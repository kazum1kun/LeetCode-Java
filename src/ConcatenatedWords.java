import java.util.*;

/**
 * #472 Concatenated Words https://leetcode.com/problems/concatenated-words/
 * 282ms/46.8MB (Beats 8.96%/95.24%)
 */

public class ConcatenatedWords {
    private boolean formable(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;

        boolean[] formableFrom = new boolean[word.length() + 1];
        formableFrom[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!formableFrom[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    formableFrom[i] = true;
                    break;
                }
            }
        }
        return formableFrom[word.length()];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> prefix = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (formable(word, prefix)) {
                result.add(word);
            }
            prefix.add(word);
        }

        return result;
    }
}
