import java.util.HashSet;
import java.util.Set;

/**
 * #3 Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Brute Force Version, TLE
 */


public class LongestSubstringNoRepBF {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (longest >= s.length() - i) break;
            longest = Math.max(checkSubstring(s.substring(i)), longest);
        }

        return longest;
    }

    public static int checkSubstring(String s) {
        if (s.length() < 2) return s.length();

        int longest = 0;
        int current = 0;
        Set<Character> seen = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (seen.contains(ch)) {
                seen.clear();
                seen.add(ch);
                current = 1;
            } else {
                seen.add(ch);
                current++;
            }
            longest = Math.max(longest, current);
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));               // 0
        System.out.println(lengthOfLongestSubstring("s"));              // 1
        System.out.println(lengthOfLongestSubstring("ss"));             // 1
        System.out.println(lengthOfLongestSubstring("sfgsggegvedffd")); // 5
        System.out.println(lengthOfLongestSubstring("qwfypoibn"));      // 9
        System.out.println(lengthOfLongestSubstring("aqdvbbhfrrr"));    // 5
        System.out.println(lengthOfLongestSubstring("dvdf"));           // 3
    }
}
