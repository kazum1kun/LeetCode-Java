// #415 Add Strings
// 3ms/39.6MB beats 58.09%/6.25%

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (len1 >= 0 || len2 >= 0 || carry == 1) {
            int a = len1 >= 0 ? (num1.charAt(len1--) - '0') : 0;
            int b = len2 >= 0 ? (num2.charAt(len2--) - '0') : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }
}
