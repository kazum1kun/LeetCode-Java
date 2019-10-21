import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length < 3) return result;

        TrieNode root = new TrieNode(' ', false);
        TrieNode current = root;

        for (String word : words) {

        }
    }

    private void addToTrie(TrieNode root, String s) {
        for (int i = 0; i < s.length(); i++) {

        }
    }

}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    char c;

    TrieNode(char c, boolean isEnd) {
        children = new HashMap<>();
        this.isEnd = isEnd;
        this.c = c;
    }
}
