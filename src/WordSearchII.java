import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #212 Word Search II https://leetcode.com/problems/word-search-ii/
 * Recursion + Trie
 */

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            root.addWord(word);
        }


    }

    public void find(char[][] board, TrieNode node, int x, int y) {

    }
}

class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    boolean isEnd;

    TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
        isEnd = false;
    }

    void addWord(String word) {
        if (word.length() < 1) return;
        TrieNode current = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int finalI = i;
            current.children.computeIfAbsent(chars[i],
                    z -> new TrieNode(chars[finalI]));
            current = current.children.get(chars[i]);
        }

        current.children.computeIfAbsent(chars[chars.length - 1],
                z -> new TrieNode(chars[chars.length - 1]));
        current.children.get(chars[chars.length - 1]).isEnd = true;
    }
}
