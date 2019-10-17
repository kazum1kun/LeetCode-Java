/**
 * #8 String to Integer (atoi) https://leetcode.com/problems/string-to-integer-atoi/
 * 1ms/35.8MB (beats 100.00%/100.00%)
 */

public class StringToInt {
    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;

        int pos = 0;
        int sign = 1;
        while (pos < str.length() && str.charAt(pos) == ' ') pos++;

        if (pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-')) {
            if (str.charAt(pos) == '-') {
                sign = -1;
            }
            pos++;
        }

        int total = 0;
        while (pos < str.length()) {
            int num = str.charAt(pos) - '0';
            if (num >= 0 && num <= 9) {
                if (total > Integer.MAX_VALUE/10 || (total == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else {
                    total = total * 10 + num;
                }
            } else {
                break;
            }

            pos++;
        }

        return total * sign;
    }
}
