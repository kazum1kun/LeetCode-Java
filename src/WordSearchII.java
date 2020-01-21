import java.util.*;

/**
 * #212 Word Search II https://leetcode.com/problems/word-search-ii/
 * Recursion + Trie
 */

public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII w = new WordSearchII();
        List<String> r;

        r = w.findWords(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'}},
                new String[]{"cdba"});

        for (String res : r) System.out.println(res);
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(' ', "");
        Set<String> result = new HashSet<>();
        for (String word : words) {
            root.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board, root, i, j, new boolean[board.length][board[0].length], result);
            }
        }

        return new ArrayList<>(result);
    }

    private void find(char[][] board, TrieNode node, int x, int y, boolean[][] scanned, Set<String> result) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || scanned[x][y]) return;

        if (node.children.containsKey(board[x][y])) {
            scanned[x][y] = true;

            node = node.children.get(board[x][y]);

            if (node.isEnd) {
                result.add(node.word);
            }

            // Search in all 4 directions
            find(board, node, x - 1, y, scanned, result);
            find(board, node, x + 1, y, scanned, result);
            find(board, node, x, y - 1, scanned, result);
            find(board, node, x, y + 1, scanned, result);
        }
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
        this.word = word;
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
