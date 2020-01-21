import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectingPhrases {
    public static List<String> generate_phrases(List<String> phrases) {
        Map<String, List<String>> wordMap = new HashMap<>();

        for (String phrase : phrases) {
            String firstWord = phrase.substring(0, phrase.indexOf(" "));
            wordMap.computeIfAbsent(firstWord, z -> new ArrayList<>());
            wordMap.get(firstWord).add(phrase);
        }

        List<String> result = new ArrayList<>();
        for (String phrase : phrases) {
            String lastWord = phrase.substring(phrase.lastIndexOf(" ") + 1);
            if (wordMap.containsKey(lastWord)) {
                for (String conn : wordMap.get(lastWord)) {
                    String connSliced = conn.substring(conn.indexOf(" "));
                    result.add(phrase + connSliced);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("writing code");
        test.add("code rocks");

        List<String> res = generate_phrases(test);
        for (String s : res) System.out.println(s);
    }
}
