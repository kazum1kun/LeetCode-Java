import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * #895 Maximum Frequency Stack https://leetcode.com/problems/maximum-frequency-stack/
 * 90ms/64.6MB (beats 73.62%/83.33%)
 */

public class MaxFrequencyStack {
    private Map<Integer, Stack<Integer>> freqGroup;
    private Map<Integer, Integer> freq;
    private int maxFreq;

    public MaxFrequencyStack() {
        freqGroup = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int xFreq = freq.getOrDefault(x, 0) + 1;
        freq.put(x, xFreq);
        maxFreq = Math.max(maxFreq, xFreq);

        freqGroup.computeIfAbsent(xFreq, a -> new Stack<>()).push(x);
    }

    public int pop() {
        int ret = freqGroup.get(maxFreq).pop();
        freq.put(ret, maxFreq - 1);
        if (freqGroup.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return ret;
    }
}

