import java.util.Scanner;

public class MaxStudents {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = Integer.parseInt(scan.nextLine());
        int column = Integer.parseInt(scan.nextLine());
        boolean[][] isOpen = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            String temp = scan.nextLine();
            for (int j = 0; j < column; j++) {
                isOpen[i][j] = temp.charAt(j) != '+';
            }
        }

        int count = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (isOpen[i][j]) {
                    isOpen[i][j] = false;
                    count++;
                    if (i > 0 && j > 0) {
                        isOpen[i - 1][j - 1] = false;
                    }
                    if (j > 0) {
                        isOpen[i][j - 1] = false;
                    }
                    if (j < column - 1) {
                        isOpen[i][j + 1] = false;
                    }
                    if (j < column - 1 && i > 0) {
                        isOpen[i - 1][j + 1] = false;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
