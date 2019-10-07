import java.util.HashMap;
import java.util.Map;

/**
 * #3 Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 7ms/35.9MB (beats 82.16%/100.00%)
 */


public class LongestSubstringNoRep {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Map<Character, Integer> charMap = new HashMap<>();
        int longest = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                j = Math.max(j, charMap.get(s.charAt(i)) + 1);
            }
            charMap.put(s.charAt(i), i);
            longest = Math.max(longest, i - j + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("eukera")); // 5
    }
}
