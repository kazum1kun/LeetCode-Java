import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * #937 Reorder Data in Log Files https://leetcode.com/problems/reorder-data-in-log-files/
 * 46ms/40.3MB (Beats 5.82%/14.71%)
 */
public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> stringLogs = new ArrayList<>();
        List<String> numberLogs = new ArrayList<>();

        for (String log : logs) {
            String[] tokens = log.split(" ");
            if (tokens[1].chars().allMatch(Character::isDigit)) {
                numberLogs.add(log);
            }
            else {
                stringLogs.add(log);
            }
        }

        Comparator<String> logComparator = (String e1, String e2) -> {
            String[] tokens1 = e1.split(" ");
            String[] tokens2 = e2.split(" ");

            String e1Content = e1.substring(tokens1[0].length());
            String e2Content = e2.substring(tokens2[0].length());

            int cmp = e1Content.compareTo(e2Content);

            if (cmp != 0) {
                return cmp;
            } else {
                return tokens1[0].compareTo(tokens2[0]);
            }
        };

        stringLogs.sort(logComparator);
        stringLogs.addAll(numberLogs);

        return stringLogs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));

    }
}
