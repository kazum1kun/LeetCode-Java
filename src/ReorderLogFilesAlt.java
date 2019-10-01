import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * #937 Reorder Data in Log Files (alternative impl) https://leetcode.com/problems/reorder-data-in-log-files/
 * 32ms/38.1MB (Beats 42.67%/85.29%)
 */
public class ReorderLogFilesAlt {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> stringLogs = new ArrayList<>();
        List<String> numberLogs = new ArrayList<>();

        for (String log : logs) {
            int sp = log.indexOf(' ');

            if (Character.isDigit(log.charAt(sp+1))) {
                numberLogs.add(log);
            }
            else {
                stringLogs.add(log);
            }
        }

        Comparator<String> logComparator = (String e1, String e2) -> {
            int sp1 = e1.indexOf(' ');
            int sp2 = e2.indexOf(' ');

            int cmp = e1.substring(sp1).compareTo(e2.substring(sp2));

            if (cmp != 0) {
                return cmp;
            } else {
                return e1.substring(0, sp1).compareTo(e2.substring(0, sp2));
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
