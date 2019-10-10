import java.util.*;

/**
 * #17 Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Brutal and inefficient, but it works!
 * 2ms/35.9MB (beats 6.53%/98.63)
 */

public class LetterCombo {
    private final HashMap<Character, String> numberCharMap = new HashMap<>();

    LetterCombo() {
        numberCharMap.put('2', "abc");
        numberCharMap.put('3', "def");
        numberCharMap.put('4', "ghi");
        numberCharMap.put('5', "jkl");
        numberCharMap.put('6', "mno");
        numberCharMap.put('7', "pqrs");
        numberCharMap.put('8', "tuv");
        numberCharMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        LetterCombo lc = new LetterCombo();
        List<String> res = lc.letterCombinations("23");

        for (String s : res) System.out.println(s + " ");
    }

    public List<String> letterCombinations(String digits) {
        Set<String> result = new HashSet<>();
        Set<String> oldResult = new HashSet<>();

        for (char digit : digits.toCharArray()) {
            char[] possibleChars = numberCharMap.get(digit).toCharArray();

            for (String s : oldResult) {
                for (char c : possibleChars) {
                    result.add(s + c);
                }
            }

            if (oldResult.size() == 0) {
                for (char c : possibleChars) {
                    result.add(String.valueOf(c));
                }
            }

            oldResult = new HashSet<>(result);
            result.clear();
        }

        return new ArrayList<>(oldResult);
    }
}
