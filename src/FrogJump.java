// #403 Frog Jump
// Memorization
// 42ms/44.7MB beats 53.85%/23.81%

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> jumpMap = new HashMap<>();

        for (int stone : stones) {
            jumpMap.put(stone, new HashSet<>());
        }
        jumpMap.get(0).add(0);

        for (int currentStone : stones) {
            for (int js : jumpMap.get(currentStone)) {
                for (int step = js - 1; step <= js + 1; step++) {
                    if (step > 0 && jumpMap.containsKey(currentStone + step)) {
                        jumpMap.get(currentStone + step).add(step);
                    }
                }
            }
        }
        return jumpMap.get(stones[stones.length - 1]).size() > 0;
    }
}
