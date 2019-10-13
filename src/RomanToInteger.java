/**
 * #13 Roman to Integer https://leetcode.com/problems/roman-to-integer/
 * 3ms/36.4MB (beats 100.00%/100.00%)
 * Symbol       Value
 * I             1
 * IV            4
 * V             5
 * IX            9
 * X             10
 * XL            40
 * L             50
 * XC            90
 * C             100
 * CD            400
 * D             500
 * CM            900
 * M             1000
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger i = new RomanToInteger();
        System.out.println(i.romanToInt("III"));
        System.out.println(i.romanToInt("IV"));
        System.out.println(i.romanToInt("IX"));
        System.out.println(i.romanToInt("LVIII"));
        System.out.println(i.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        if (s.length() == 0) return 0;

        int pos = 0;
        int total = 0;

        while (pos <= s.length() - 1) {
            char next = s.charAt(pos);
            char next2;
            if (pos == s.length() - 1) {
                next2 = ' ';
            } else {
                next2 = s.charAt(pos + 1);
            }

            switch (next) {
                case 'M':
                    total += 1000;
                    break;
                case 'D':
                    total += 500;
                    break;
                case 'C':
                    if (next2 == 'D') {
                        total += 400;
                        pos++;
                    } else if (next2 == 'M') {
                        total += 900;
                        pos++;
                    } else {
                        total += 100;
                    }
                    break;
                case 'L':
                    total += 50;
                    break;
                case 'X':
                    if (next2 == 'C') {
                        total += 90;
                        pos++;
                    } else if (next2 == 'L') {
                        total += 40;
                        pos++;
                    } else {
                        total += 10;
                    }
                    break;
                case 'V':
                    total += 5;
                    break;
                case 'I':
                    if (next2 == 'X') {
                        total += 9;
                        pos++;
                    } else if (next2 == 'V') {
                        total += 4;
                        pos++;
                    } else {
                        total += 1;
                    }
                    break;
            }

            pos++;
        }

        return total;
    }
}
