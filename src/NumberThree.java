import java.util.Scanner;

public class NumberThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();

        String newNum = num;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3') {
                if (i == num.length() - 1) {
                    newNum = num.substring(0, num.length() - 1) + 2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(2);
                    for (int j = i + 1; j < num.length(); j++) {
                        sb.append(9);
                    }
                    newNum = sb.toString();
                    break;
                }
            }
        }

        System.out.println(newNum);
    }
}
