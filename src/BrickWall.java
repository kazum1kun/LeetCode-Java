// #554 Brick Wall
// Look for the path with longest opening and keep track of it
// 9ms/44.9MB beats 90.28%/100.0%

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public static void main(String[] args) {
        BrickWall bw = new BrickWall();
        List<Integer> l1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> l2 = Arrays.asList(3, 1, 2);
        List<Integer> l3 = Arrays.asList(1, 3, 2);
        List<Integer> l4 = Arrays.asList(2, 4);
        List<Integer> l5 = Arrays.asList(3, 1, 2);
        List<Integer> l6 = Arrays.asList(1, 3, 1, 1);
        List<List<Integer>> ll = Arrays.asList(l1, l2, l3, l4, l5, l6);

        System.out.println(bw.leastBricks(ll));
    }

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) return 0;
        if (wall.size() == 0) return 0;

        Map<Integer, Integer> brickCrossMap = new HashMap<>();
        int count = 0;

        for (List<Integer> list : wall) {
            int pos = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                pos += list.get(i);
                brickCrossMap.put(pos, brickCrossMap.getOrDefault(pos, 0) + 1);
                count = Math.max(count, brickCrossMap.get(pos));
            }
        }

        return wall.size() - count;
    }
}
