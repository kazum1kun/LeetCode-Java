import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #212 Word Search II https://leetcode.com/problems/word-search-ii/
 * Recursion + Trie
 */

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(' ', "");
        for (String word : words) {
            root.addWord(word);
        }


    }

    public void find(char[][] board, TrieNode node, int x, int y, boolean[][] scanned, List<String> result) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length || scanned[x][y]) return;

        scanned[x][y] = true;
        if (node.children.containsKey(board[x][y])) {
            node = node.children.get(board[x][y]);
        }
        // Search in all 4 directions

    }
}

class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    String word;
    boolean isEnd;

    TrieNode(char c, String word) {
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
                    z -> new TrieNode(chars[finalI], word.substring(0, finalI + 1)));
            current = current.children.get(chars[i]);
        }

        current.children.computeIfAbsent(chars[chars.length - 1],
                z -> new TrieNode(chars[chars.length - 1], word));
        current.children.get(chars[chars.length - 1]).isEnd = true;
    }
}
